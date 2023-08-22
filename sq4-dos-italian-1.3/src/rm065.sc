;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm065 0
)

(local
	[local0 46] = [26 0 27 36 42 48 66 50 86 42 86 89 96 99 133 100 152 87 169 97 192 97 194 116 204 124 201 162 230 160 231 148 241 143 243 148 246 160 271 162 273 155 319 149 319 0]
	[local46 16] = [0 70 106 173 81 184 75 172 65 168 41 175 40 182 0 183]
	[local62 48] = [0 0 26 0 27 35 43 49 67 51 86 43 86 89 94 100 118 103 138 100 151 86 166 97 191 98 192 115 203 122 199 164 190 167 186 163 151 174 143 167 128 173 111 170 105 172 0 70]
	[local110 32] = [0 70 79 148 78 151 78 152 76 153 74 152 73 150 62 139 57 140 43 126 23 113 15 107 3 93 1 90 1 88 0 87]
)

(instance rm065 of SQRoom
	(properties
		picture 65
		style 10
		horizon 48
		north 50
		west 60
		vanishingX 0
		vanishingY -65
	)

	(method (init)
		(switch gPrevRoomNum
			(north
				(HandsOff)
				(self setScript: enterScript)
			)
			(west
				(if (> (gEgo y:) 179)
					(gEgo y: 179)
				)
			)
			(else
				(gEgo x: 160 y: 160)
			)
		)
		(gEgo init:)
		(if (== ((gInventory at: 1) owner:) 65) ; rope
			(aRope init: stopUpd:)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 179 185 179 192 159 227 149 152 103 139 109 101 109 82 99 77 85 91 71 105 69 86 51 77 55 40 54 22 46 18 30 30 26 6 0 319 0 319 189 0 189
					yourself:
				)
		)
		(buildingPoly points: @local0 size: 23)
		(streetPoly points: @local46 size: 8)
		(sidewalkPoly points: @local62 size: 24)
		(liquidPoly points: @local110 size: 16)
		(theRubble init:)
		(theRedBldg init:)
		(theLiquid init:)
		(theGrate init:)
		(theStreet init:)
		(theSidewalk init:)
		(theArea init:)
		(if (not (IsFlag 0))
			(self setRegions: 701) ; street
		)
		(super init:)
		(self setRegions: 705) ; bunny
	)

	(method (newRoom newRoomNumber)
		(cond
			(
				(and
					(== (gEgo edgeHit:) EDGE_TOP)
					(!= script exitScript)
					(!= script (ScriptID 701 3)) ; cyborgScreams
					(!= ((ScriptID 701 1) script:) (ScriptID 701 4)) ; deathDroid, droidShoots
				)
				(HandsOff)
				(self setScript: exitScript 0 1)
			)
			((and (== (gEgo edgeHit:) EDGE_TOP) (not (script register:)))
				(super newRoom: newRoomNumber)
			)
			(else
				(super newRoom: newRoomNumber)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 4 -1 setMotion: MoveTo 17 49 self)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 5 -10 self)
			)
			(1
				(= register 0)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance getRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 160 183 self)
			)
			(1
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 2) self
				)
			)
			(2
				(HandsOn)
				(aRope dispose:)
				(SetScore 39 5)
				(self cue:)
			)
			(3
				(Print 65 0) ; "You take possession of the small, frayed, useless-looking length of rope."
				(gEgo get: 1) ; rope
				(client setScript: 0)
			)
		)
	)
)

(instance aRope of View
	(properties
		x 160
		y 189
		z 10
		description {rope}
		sightAngle 45
		lookStr {It's a lightweight, worn piece of rope.}
		view 33
		priority 14
		signal 16400
	)

	(method (doit)
		(super doit:)
		(if (== (gCurRoom curPic:) 31)
			(self z: 1000)
		else
			(self z: 10)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: getRope)
			)
			(11 ; Smell
				(Print 65 1) ; "Smells like a frayed old length of rope."
			)
			(10 ; Taste
				(Print 65 2) ; "You run the risk of tying your tongue in a frayed knot."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRubble of Feature
	(properties
		x 160
		y 188
		nsBottom 200
		nsRight 320
		description {rubble}
		onMeCheck 64
		lookStr {The clearing ends here. Progress south is not possible over the jagged terrain.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (!= ((gInventory at: 1) owner:) 65) ; rope
					(Print 65 3) ; "The rubble is too dangerous for you to mess around on."
				else
					(Print 65 4) ; "The rubble is too dangerous for you to mess with - except maybe for that knotted-looking thing."
				)
			)
			(11 ; Smell
				(Print 65 5) ; "The faint aroma of burnt hemp teases playfully around your nostrils."
			)
			(10 ; Taste
				(Print 65 6) ; "You swish the rubble around in your mouth a bit, but the flavor is too subtle to identify. And the bouquet leaves a LOT to be desired."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRedBldg of Feature
	(properties
		x 280
		y 180
		description {red building}
		sightAngle 40
		lookStr {A battered and boarded storefront shows the wear and tear a little war can have on it.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: buildingPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 65 7) ; "The building is closed-up with welded metal panels enhancing the non-access accent."
			)
			(11 ; Smell
				(Print 65 8) ; "There's a sweet, fruity odor coming from the building."
			)
			(10 ; Taste
				(Print 65 9) ; "Mmmmmm! Wild Berry!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buildingPoly of Polygon
	(properties)
)

(instance theLiquid of Feature
	(properties
		x 39
		y 115
		nsBottom 200
		nsRight 320
		description {solidified run-off}
		sightAngle 45
		lookStr {What looks like fluid is actually a sedimentary mixture of toxic atmospheric solids.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: liquidPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Smell
				(Print 65 10) ; "It smells just as good as it looks."
			)
			(10 ; Taste
				(Print 65 11) ; "It tastes just as good as it smells. And as an added bonus you can attempt to predict which vital organs will filter and collect quantities of some of the potentially lethal elements of the atmospheric solids deposited in the fine sediment. Heavy metals, various corrosives... who knows what could be in the environmental seasoning?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance liquidPoly of Polygon
	(properties)
)

(instance theGrate of Feature
	(properties
		x 85
		y 163
		nsBottom 200
		nsRight 320
		description {grate}
		sightAngle 45
		onMeCheck 512
		lookStr {The grate is anchored securely by bolts with corroded heads.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 65 12) ; "The bolted-down grate won't budge."
			)
			(11 ; Smell
				(Print 65 13) ; "It smells grate! (Did I really say that?)"
			)
			(10 ; Taste
				(Print 65 14) ; "It tastes grate!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theStreet of Feature
	(properties
		description {street}
		lookStr {It seems to have everything you'd look for in a street with the exception of vehicles to use it.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: streetPoly)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(11 ; Smell
				(Print 65 15) ; "The street stinks. Somebody must have been driving on it."
			)
			(10 ; Taste
				(Print 65 16) ; "A strange sense of revulsion prevents you from licking the street. Not so strange, actually."
			)
			(4 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance streetPoly of Polygon
	(properties)
)

(instance theSidewalk of Feature
	(properties
		description {sidewalk}
		lookStr {It's very pleasant looking.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalkPoly)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Taste
				(Print 65 17) ; "You clean a little patch of the sidewalk with your tongue."
			)
			(11 ; Smell
				(Print 65 18) ; "The sidewalk stinks. Somebody must have been walking on it."
			)
			(4 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sidewalkPoly of Polygon
	(properties)
)

(instance theArea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
		lookStr {You are at the southeastern corner of the clearing. Rubble restricts southern passage.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

