;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm013 0
)

(local
	local0
	local1
	local2
	[local3 18] = [10 113 240 113 260 120 260 128 209 128 170 134 107 134 107 128 10 129]
	[local21 8] = [0 161 103 176 108 189 0 189]
	[local29 8] = [319 163 166 163 173 189 319 189]
	[local37 8] = [0 102 319 102 319 0 0 0]
	[local45 8] = [127 117 143 117 143 125 127 125]
	local53
	local54
	local55
)

(instance rm013 of Rm
	(properties
		picture 13
		east 9
		south 12
		west 14
	)

	(method (init)
		(super init:)
		(= global320 69)
		(= global321 137)
		(= global325 {"Let's move on, Graham!"})
		(= local54 (gEgo illegalBits:))
		(gEgo illegalBits: $8000 ignoreHorizon: 1)
		(if (!= (gGlobalSound number:) 24)
			(gGlobalSound number: 24 loop: -1 play:)
		)
		(if (== ((gInventory at: 6) owner:) 200) ; Brass_Bottle
			(if (== ((gInventory at: 34) owner:) 13) ; Tambourine
				(tambourine init:)
				(glint init: setScript: glimmer)
				(self addObstacle: poly5)
			)
			(self setFeatures: grassRoom)
		else
			(gGlobalSound2 number: 803 loop: -1 vol: 127 playBed:)
			(Load rsVIEW 344)
			(chair init: stopUpd:)
			(body setCycle: Fwd cycleSpeed: 3 init:)
			(oxHead cycleSpeed: 2 init:)
			(if (== global81 3)
				(oxTail cycleSpeed: 2 init: setScript: oxScript)
				(coals setCycle: Fwd init:)
			else
				(coals init: stopUpd:)
				(oxTail init: stopUpd:)
			)
			(gAddToPics add: barrel shovel camp wagon doit:)
			(self setFeatures: camp ox barrel shovel wagon addObstacle: poly1)
		)
		(poly1 points: @local3 size: 9)
		(poly2 points: @local21 size: 4)
		(poly3 points: @local29 size: 4)
		(poly4 points: @local37 size: 4)
		(poly5 points: @local45 size: 4)
		(self addObstacle: poly2 poly3 poly4)
		(self setRegions: 202) ; owl
		(gEgo normal: 1 view: 0 setPri: -1 offset: 3 init:)
		(switch gPrevRoomNum
			(west
				(gEgo posn: -20 129 loop: 0)
				(HandsOff)
				(self setScript: relievedScript)
			)
			(east
				(gEgo posn: 315 125)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(south
				(gEgo posn: 133 180)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(else
				(gEgo posn: 187 127)
				(HandsOff)
				(self setScript: egoWalk)
			)
		)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(not (IsFlag 52))
					(gCast contains: body)
					(< (gEgo y:) 188)
				)
				(SetFlag 52)
				(self setScript: warnScript)
			)
			((= local0 (self edgeToRoom: (gEgo edgeHit:)))
				(if (== local0 (gCurRoom west:))
					(gEgo loop: 1)
					(RedrawCast)
					(Say 75 13 0 67 10 10 25 10) ; "There's nothing but a hot, dry desert further west. Most people avoid it, because there are bandits out there! If you insist on going, I'll wait for you HERE!"
					(gCurRoom newRoom: local0)
				else
					((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				)
			)
			(
				(and
					(gEgo inRect: 170 120 217 145)
					(not (gCast contains: gypsy))
					(gCast contains: chair)
				)
				(HandsOff)
				(gEgo setMotion: 0)
				(self setScript: standScript)
			)
			((and (> (gEgo distanceTo: gypsy) 50) (gCast contains: gypsy))
				(self setScript: sitDown)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(gEgo illegalBits: local54)
		(gGlobalSound fade:)
		(gGlobalSound2 fade:)
		(super dispose:)
	)
)

(instance glimmer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(glint setCycle: End)
				(-- state)
				(= seconds 10)
			)
		)
	)
)

(instance warnScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(Say 75 13 1 67 20 100 25 7) ; "Keep your eye on the gypsies, Graham. I don't trust 'em."
				(client setScript: 0)
			)
		)
	)
)

(instance relievedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gEgo setMotion: MoveTo 4 129 self)
			)
			(2
				(Say 75 13 2 67 20 100 25 7) ; "Well, there you are! I was starting to get concerned!"
				(Say 160 13 3 67 20 20 25 8) ; "Don't worry about me, Cedric. I'm used to this kind of thing."
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance standScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(body dispose:)
				(chair view: 346 loop: 4 cel: 0 setCycle: End self)
			)
			(1
				(chair view: 346 loop: 0 cel: 1 stopUpd:)
				(gypsy
					setCycle: Walk
					setLoop: 0
					illegalBits: 0
					setMotion: MoveTo 187 128 self
					init:
				)
			)
			(2
				(gypsy setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(if (not local2)
					(++ local2)
					(Say 103 13 4 25 8) ; "Eet veel cost you one gold coin to see Madame Mushka."
				else
					(Say 103 13 5 25 5) ; "Zee cost eez one gold coin."
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gypsy
					setCycle: Walk
					setLoop: 1
					illegalBits: 0
					setMotion: MoveTo 214 127 self
				)
			)
			(1
				(gypsy dispose:)
				(chair
					view: 346
					loop: 4
					cel: (- (NumCels chair) -1)
					setCycle: Beg self
				)
			)
			(2
				(body setCycle: Fwd cycleSpeed: 3 init:)
				(chair loop: 0 cel: 0 forceUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance giveCoinSit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(body dispose:)
				(chair view: 346 loop: 4 cel: 0 setCycle: End self)
				(gEgo setMotion: PolyPath 200 132 self)
			)
			(1)
			(2
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 24
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(chair view: 346 loop: 0 cel: 1 stopUpd:)
				(gypsy
					cel: 0
					cycleSpeed: 2
					x: 224
					setLoop: 3
					illegalBits: 0
					setCycle: End self
					init:
				)
			)
			(4
				(gypsy setLoop: 4 cel: 0 setCycle: End self)
			)
			(5
				(if local55
					(Say 103 13 6 67 10 10 25 10) ; "Vell, eet eez not a gold coin, but I guess eet veel be fine. Go on een and see Madame Mushka."
				else
					(Say 103 13 7 67 10 10 25 5) ; "You may see Madame Mushka now."
				)
				(gEgo
					normal: 1
					view: 0
					setCycle: Walk
					cycleSpeed: 0
					ignoreControl: 2
					setMotion: MoveTo 187 127 self
				)
				((gEgo head:) show:)
			)
			(6
				(gCurRoom newRoom: 77)
			)
		)
	)
)

(instance giveCoinStand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 187 137 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 24
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gypsy
					cel: 0
					setLoop: 3
					illegalBits: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(gypsy setLoop: 4 cel: 0 setCycle: End self)
			)
			(4
				(if local55
					(Say 103 13 6 67 10 10 25 10) ; "Vell, eet eez not a gold coin, but I guess eet veel be fine. Go on een and see Madame Mushka."
				else
					(Say 103 13 7 67 10 10 25 5) ; "You may see Madame Mushka now."
				)
				(gypsy
					setCycle: Walk
					setLoop: 1
					illegalBits: 0
					cycleSpeed: 0
					setMotion: MoveTo 200 127 self
				)
			)
			(5
				(gEgo
					normal: 1
					view: 0
					setCycle: Walk
					cycleSpeed: 0
					ignoreControl: 2
					setMotion: MoveTo 187 127 self
				)
				((gEgo head:) show:)
			)
			(6
				(gCurRoom newRoom: 77)
			)
		)
	)
)

(instance oxScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (< (Random 1 100) 10)
			(oxTail setCycle: Beg)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oxHead loop: 1 setCycle: End)
				(= seconds 5)
			)
			(1
				(oxHead setCycle: Beg self)
			)
			(2
				(oxHead loop: 5 cel: 0 setCycle: CT 1 1)
				(gGlobalSound3 number: 880 loop: 1 vol: 127 play:)
				(= cycles 30)
			)
			(3
				(oxHead setCycle: Fwd)
				(= state -1)
				(= seconds (Random 5 20))
			)
		)
	)
)

(instance egoWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 146 self)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getTambourine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 146 122 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 56 loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(tambourine dispose:)
				((gCurRoom obstacles:) delete: poly5)
				(glint setScript: 0 dispose:)
				(SetScore 2)
				(gEgo get: 34 setCycle: Beg self) ; Tambourine
			)
			(3
				(PrintDC 13 8) ; "Not seeing the tambourine's owner, Graham bends down and rescues it from the ground."
				(gEgo
					normal: 1
					view: 0
					setCycle: Walk
					cycleSpeed: 0
					loop: 7
					cel: 1
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance wagon of RPicView
	(properties
		y 125
		x 120
		view 342
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 13 9) ; "A gypsy wagon is encamped here at the edge of the woods. On the side of the wagon, the words "Fortune Teller" have been painted."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance door of Prop ; UNUSED
	(properties
		view 342
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 13 10) ; "The wagon door looks inviting to those who wish to have their fortunes told."
					(event claimed: 1)
				)
				(3 ; Do
					(gEgo setMotion: PolyPath 186 120)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance oxHead of Prop
	(properties
		y 112
		x 89
		view 342
		loop 1
		priority 8
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 13 11) ; "A large ox, tied to the gypsies' wagon, peacefully munches on grass."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 13 12) ; "Graham finds the huge beast completely uninteresting."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance oxTail of Prop
	(properties
		y 145
		x 15
		z 28
		view 342
		loop 2
		priority 8
		signal 16400
	)
)

(instance ox of RFeature
	(properties
		nsTop 83
		nsLeft 17
		nsBottom 118
		nsRight 97
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 13 11) ; "A large ox, tied to the gypsies' wagon, peacefully munches on grass."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 13 12) ; "Graham finds the huge beast completely uninteresting."
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 13 13) ; "The ox's mouth is too full of grass to even attempt a conversation with Graham!"
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 13 14) ; "The ox is not interested in any of Graham's possessions."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance body of Prop
	(properties
		y 127
		x 232
		z 17
		view 346
		loop 1
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 13 15) ; "Within the gypsy encampment, Graham notices a dark, burly man who keeps a suspicious eye on him and Cedric."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 13 16) ; "The burly man keeps a watchful eye on Graham and Cedric."
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(11 ; Gold_Coin
							(if (gEgo has: 27) ; Amulet
								(Say 103 13 17 67 10 10 25 10) ; "Madame Mushka eez tired. No more for today."
							else
								(HandsOff)
								(gEgo put: 11 13) ; Gold_Coin
								(SetScore 3)
								(gCurRoom setScript: giveCoinSit)
							)
							(event claimed: 1)
						)
						(3 ; Golden_Needle
							(if (gEgo has: 27) ; Amulet
								(Say 103 13 17 67 10 10 25 10) ; "Madame Mushka eez tired. No more for today."
							else
								(HandsOff)
								(= local55 1)
								(gEgo put: 3 13) ; Golden_Needle
								(gCurRoom setScript: giveCoinSit)
							)
							(event claimed: 1)
						)
						(4 ; Coin
							(Say 103 13 18 67 10 10 25 10) ; "Eet costs one GOLD coin to see Madame Mushka, not one SILVER coin!"
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
					)
				)
				(4 ; Talk
					(PrintDC 13 19) ; "The sullen man doesn't look like the conversational sort."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance chair of Prop
	(properties
		y 127
		x 235
		view 346
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(5 ; Inventory
					(if (not (gCast contains: gypsy))
						(switch global69
							(11 ; Gold_Coin
								(if (gEgo has: 27) ; Amulet
									(Say 103 13 17 67 10 10 25 10) ; "Madame Mushka eez tired. No more for today."
								else
									(HandsOff)
									(gEgo put: 11 13) ; Gold_Coin
									(SetScore 3)
									(gCurRoom setScript: giveCoinSit)
								)
								(event claimed: 1)
							)
							(3 ; Golden_Needle
								(if (gEgo has: 27) ; Amulet
									(Say 103 13 17 67 10 10 25 10) ; "Madame Mushka eez tired. No more for today."
								else
									(HandsOff)
									(= local55 1)
									(gEgo put: 3 13) ; Golden_Needle
									(gCurRoom setScript: giveCoinSit)
								)
								(event claimed: 1)
							)
							(28 ; Wand
								(event claimed: 0)
							)
							(4 ; Coin
								(Say 103 13 18 67 10 10 25 10) ; "Eet costs one GOLD coin to see Madame Mushka, not one SILVER coin!"
								(event claimed: 1)
							)
							(else
								(Say 103 13 20) ; "Zat eez NOT a gold coin!"
								(event claimed: 1)
							)
						)
					)
				)
				(4 ; Talk
					(if (and (not (gCast contains: gypsy)) (not local53))
						(PrintDC 13 19) ; "The sullen man doesn't look like the conversational sort."
						(++ local53)
						(event claimed: 1)
					)
				)
				(2 ; Look
					(if (not (gCast contains: gypsy))
						(PrintDC 13 15) ; "Within the gypsy encampment, Graham notices a dark, burly man who keeps a suspicious eye on him and Cedric."
						(event claimed: 1)
					)
				)
				(3 ; Do
					(if (not (gCast contains: gypsy))
						(PrintDC 13 16) ; "The burly man keeps a watchful eye on Graham and Cedric."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance gypsy of Act
	(properties
		y 127
		x 214
		view 344
		cel 7
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 13 21) ; "The dark gypsy man bars Graham's entry into the fortune teller's wagon without proper payment."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 13 16) ; "The burly man keeps a watchful eye on Graham and Cedric."
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(11 ; Gold_Coin
							(if (gEgo has: 27) ; Amulet
								(Say 103 13 17 67 10 10 25 10) ; "Madame Mushka eez tired. No more for today."
							else
								(HandsOff)
								(SetScore 3)
								(gEgo put: 11 13) ; Gold_Coin
								(gCurRoom setScript: giveCoinStand)
							)
							(event claimed: 1)
						)
						(3 ; Golden_Needle
							(if (gEgo has: 27) ; Amulet
								(Say 103 13 17 67 10 10 25 10) ; "Madame Mushka eez tired. No more for today."
							else
								(HandsOff)
								(= local55 1)
								(gEgo put: 3 13) ; Golden_Needle
								(gCurRoom setScript: giveCoinStand)
							)
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(4 ; Coin
							(Say 103 13 18 67 10 10 25 10) ; "Eet costs one GOLD coin to see Madame Mushka, not one SILVER coin!"
							(event claimed: 1)
						)
						(else
							(Say 103 13 20) ; "Zat eez NOT a gold coin!"
							(event claimed: 1)
						)
					)
				)
				(4 ; Talk
					(PrintDC 13 19) ; "The sullen man doesn't look like the conversational sort."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance barrel of RPicView
	(properties
		y 128
		x 121
		view 342
		loop 3
		signal 16384
	)
)

(instance shovel of RPicView
	(properties
		y 129
		x 134
		view 342
		loop 3
		cel 1
		signal 16384
	)
)

(instance coals of Prop
	(properties
		y 132
		x 152
		z 7
		view 342
		loop 4
		cel 1
		signal 16384
		cycleSpeed 2
	)
)

(instance camp of RPicView
	(properties
		y 132
		x 152
		view 342
		loop 3
		cel 2
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 13 22) ; "A steaming pot of stew bubbles over a small campfire near the gypsy wagon."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 13 23) ; "Obviously, the man wouldn't tolerate Graham taking his supper."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance grassRoom of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 13 24) ; "Graham notices a grassy clearing at the edge of the woods."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance glint of Prop
	(properties
		y 120
		x 135
		view 342
		loop 6
		signal 16401
		cycleSpeed 2
	)
)

(instance tambourine of Prop
	(properties
		y 127
		x 135
		view 342
		loop 3
		cel 4
		priority 3
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 13 25) ; "A tambourine lies on the ground near the abandoned gypsy encampment."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getTambourine)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

