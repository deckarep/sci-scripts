;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 702)
(include sci.sh)
(use Main)
(use Sq4Feature)
(use IconBar)
(use PolyPath)
(use Rev)
(use Motion)
(use Game)
(use Inventory)
(use System)

(public
	sewer 0
	theDeathScript 1
	theSlime 2
	theDrip 3
	theSlimeScript 4
	theDrip1 5
	theDrip2 6
)

(local
	local0
	local1
	local2
	[local3 52]
	local55
	local56
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	local64
	local65
	local66
	local67
)

(procedure (localproc_0)
	(cond
		((== (theSlime loop:) 3)
			(= local55 (- (theSlime x:) 9))
			(= local56 (- (theSlime y:) 27))
			(= local57 (- (theSlime x:) 9))
			(= local58 (+ (theSlime y:) 26))
			(sewer distance: (localproc_1))
			(= local55 (- (theSlime x:) 9))
			(= local56 (- (theSlime y:) 27))
			(= local57 (+ (theSlime x:) 9))
			(= local58 (- (theSlime y:) 27))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x:) 9))
			(= local56 (- (theSlime y:) 27))
			(= local57 (+ (theSlime x:) 9))
			(= local58 (+ (theSlime y:) 26))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (- (theSlime x:) 9))
			(= local56 (+ (theSlime y:) 26))
			(= local57 (+ (theSlime x:) 9))
			(= local58 (+ (theSlime y:) 26))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
		)
		((== (theSlime loop:) 2)
			(= local55 (- (theSlime x:) 35))
			(= local56 (- (theSlime y:) 5))
			(= local57 (- (theSlime x:) 35))
			(= local58 (+ (theSlime y:) 6))
			(sewer distance: (localproc_1))
			(= local55 (- (theSlime x:) 35))
			(= local56 (- (theSlime y:) 5))
			(= local57 (+ (theSlime x:) 35))
			(= local58 (- (theSlime y:) 5))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x:) 35))
			(= local56 (- (theSlime y:) 5))
			(= local57 (+ (theSlime x:) 35))
			(= local58 (+ (theSlime y:) 6))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x:) 35))
			(= local56 (+ (theSlime y:) 6))
			(= local57 (- (theSlime x:) 35))
			(= local58 (+ (theSlime y:) 6))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
		)
		((== (theSlime loop:) 0)
			(= local55 (- (theSlime x:) 28))
			(= local56 (+ (theSlime y:) 15))
			(= local57 (+ (theSlime x:) 9))
			(= local58 (- (theSlime y:) 17))
			(sewer distance: (localproc_1))
			(= local55 (- (theSlime x:) 28))
			(= local56 (+ (theSlime y:) 15))
			(= local57 (- (theSlime x:) 10))
			(= local58 (+ (theSlime y:) 21))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (- (theSlime x:) 10))
			(= local56 (+ (theSlime y:) 21))
			(= local57 (+ (theSlime x:) 23))
			(= local58 (- (theSlime y:) 9))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x:) 9))
			(= local56 (- (theSlime y:) 17))
			(= local57 (+ (theSlime x:) 23))
			(= local58 (- (theSlime y:) 9))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
		)
		((== (theSlime loop:) 1)
			(= local55 (- (theSlime x:) 24))
			(= local56 (- (theSlime y:) 9))
			(= local57 (+ (theSlime x:) 13))
			(= local58 (+ (theSlime y:) 23))
			(sewer distance: (localproc_1))
			(= local55 (- (theSlime x:) 24))
			(= local56 (- (theSlime y:) 9))
			(= local57 (- (theSlime x:) 8))
			(= local58 (- (theSlime y:) 17))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (- (theSlime x:) 8))
			(= local56 (- (theSlime y:) 17))
			(= local57 (+ (theSlime x:) 28))
			(= local58 (+ (theSlime y:) 16))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x:) 13))
			(= local56 (+ (theSlime y:) 23))
			(= local57 (+ (theSlime x:) 28))
			(= local58 (+ (theSlime y:) 16))
			(if (< (= local61 (localproc_1)) (sewer distance:))
				(sewer distance: local61)
			)
		)
	)
)

(procedure (localproc_1 &tmp temp0)
	(if
		(and
			(<=
				0
				(localproc_2
					(- local57 local55)
					(- local58 local56)
					(- local59 local55)
					(- local60 local56)
				)
			)
			(<=
				0
				(localproc_2
					(- local55 local57)
					(- local56 local58)
					(- local59 local57)
					(- local60 local58)
				)
			)
		)
		(return
			(if (= temp0 (GetDistance local55 local56 local57 local58))
				(/
					(Abs
						(localproc_2
							(- local58 local56)
							(- local55 local57)
							(- local59 local55)
							(- local60 local56)
						)
					)
					temp0
				)
			else
				0
			)
		)
	else
		(return
			(Min
				(GetDistance local59 local60 local55 local56)
				(GetDistance local59 local60 local57 local58)
			)
		)
	)
)

(procedure (localproc_2 param1 param2 param3 param4)
	(if (< (sewer distance:) 200)
		(return (+ (* param1 param3) (* param2 param4)))
	else
		(return
			(+
				(* (+ (/ param1 2) 1) (+ (/ param3 2) 1))
				(* (+ (/ param2 2) 1) (+ (/ param4 2) 1))
			)
		)
	)
)

(class sewer of Rgn
	(properties
		modNum 702
		regionVer 22891
		roomVer 0
		location 0
		cantDie 0
		status 0
		distance 0
		prevDistance 0
		oldDistance 0
		angle 0
		scoopLoop 0
		rmTimer 0
		dbg 0
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 75 80 85 90 95 100 105 110 115))
		(= initialized 0)
		(theSlime setCycle: 0 setMotion: 0)
		(super newRoom: newRoomNumber &rest)
		(= local67 0)
		(self
			oldDistance: (sewer prevDistance:)
			prevDistance: (sewer distance:)
		)
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 75)
		(Load rsVIEW 76)
		(Load rsVIEW 4)
		(Load rsSOUND 806)
		(Load rsSOUND 805)
		(Load rsSOUND 819)
		(sewer cantDie: 0)
		(if (OneOf gCurRoomNum 75 80 85 105 115)
			(thePipes init:)
			(theConduit init:)
			(theVent
				init:
				x:
					(switch gCurRoomNum
						(75 77)
						(80 158)
						(85 242)
						(105 131)
						(115 188)
					)
				y:
					(switch gCurRoomNum
						(75 81)
						(80 40)
						(85 80)
						(else 2)
					)
			)
		else
			(thePipes init:)
			(theConduit init:)
		)
		(if (not (sewer location:))
			(theSlime posn: 1000 1000)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (!= local64 (GetTime 1)) ; SysTime12
			(= local64 (GetTime 1)) ; SysTime12
			(= local65 1)
		)
		(if local65
			(= local65 0)
			(++ local67)
			(self rmTimer: local67)
			(if (== (self status:) 4)
				(++ local66)
				(if (and (not (sewer cantDie:)) (> local66 5))
					(HandsOff)
					(gNarrator modNum: 702 say: 1) ; "You took a little too long. Now it's slime time!"
					(gCurRoom setScript: theDeathScript)
				)
			)
		)
		(= local59 (gEgo x:))
		(= local60 (gEgo y:))
		(if (and (!= (theSlime x:) 1000) (!= (theSlime y:) 1000))
			(localproc_0)
		)
		(sewer
			angle:
				(GetAngle (gEgo x:) (gEgo y:) (theSlime x:) (theSlime y:))
		)
		(if
			(and
				(< (sewer distance:) 5)
				(== (sewer status:) 4)
				(not local0)
				(not (sewer cantDie:))
			)
			(gCurRoom setScript: theDeathScript)
			(sewer status: 6)
		)
		(if (and (> (sewer distance:) 17) (== (sewer status:) 4))
			(sewer status: 3)
			(theSlime setScript: theSlimeScript)
			(= local66 0)
		)
		(if
			(and
				(< (sewer status:) 7)
				(> (sewer distance:) 0)
				(< (sewer distance:) 9)
				(== (sewer status:) 3)
				(== (sewer location:) gCurRoomNum)
				(not (sewer cantDie:))
			)
			(sewer status: 4)
			(theSlime setScript: 0 setCycle: Fwd setMotion: 0)
		)
	)
)

(instance theDrip of Sq4Actor
	(properties
		yStep 1
		view 75
		signal 26624
		illegalBits 0
		xStep 1
		lookStr 2
	)

	(method (init)
		(super init:)
		(Load rsSCRIPT 969)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 702 say: 2) ; "A green gel-type mass flows out the vent and down the conduit section."
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance theDeathScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (self state:) 4) (<= (gLongSong prevSignal:) -1))
			(self cue:)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(sewer status: 7)
				(gLongSong2 vol: 0 loop: 1 fade: 0 10 10 0)
				(gLongSong vol: 127 number: 818 loop: 1 playBed:)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					cycleSpeed: 6
					setMotion: 0
					setLoop: -1
					setHeading: 180 self
				)
			)
			(1
				(theSlime moveSpeed: (- gGameSpeed 2) cycleSpeed: 3 setStep: 3 3)
				(switch (theSlime loop:)
					(2
						(theSlime
							setMotion:
								MoveTo
								(gEgo x:)
								(- (gEgo y:) 3)
								self
						)
					)
					(else
						(theSlime
							setMotion: MoveTo (gEgo x:) (gEgo y:) self
						)
					)
				)
				(gEgo view: 76 setLoop: 0 setCel: 0)
			)
			(2
				(theSlime cycleSpeed: 4)
				(gEgo cycleSpeed: 5 setCycle: End self)
			)
			(3
				(gEgo cycleSpeed: 7 setLoop: 1 setCycle: End self)
			)
			(4
				(theSlime setCycle: Fwd)
				(gEgo hide:)
			)
			(5
				(gLongSong number: 0 vol: 0 stop:)
				(gLongSong2 number: 0 vol: 0 stop:)
				(self dispose:)
				(EgoDead 3 13) ; "As the green slime dissolves the flesh from your bones, you think, "Hey! This stuff consumes 47 times its weight in acid!""
			)
		)
	)
)

(instance theSlime of Sq4Actor
	(properties
		view 75
		signal 26624
		illegalBits 0
		xStep 2
		lookStr 3
	)

	(method (init)
		(if (== (gLongSong2 vol:) 0)
			(gLongSong vol: 0 fade: 0 10 10 0)
			(gLongSong2 vol: 127 play:)
		)
		(self setCycle: Fwd cycleSpeed: 6 moveSpeed: (- gGameSpeed 2) script: 0)
		(super init:)
	)

	(method (setSpeed)
		(= moveSpeed (- gGameSpeed 2))
	)

	(method (dispose)
		(super dispose:)
		(= local67 0)
		(if (and (!= (sewer location:) gCurRoomNum) (== (sewer status:) 3))
			(if (gLongSong2 number:)
				(gLongSong2 vol: 0 fade: 0 10 10 0)
			)
			(if (gLongSong number:)
				(gLongSong vol: 127 playBed:)
			)
		)
		(if (!= (sewer status:) 3)
			(if (gLongSong2 number:)
				(gLongSong2 vol: 0 fade: 0 10 10 0)
			)
			(if (gLongSong number:)
				(gLongSong vol: 127 playBed:)
			)
		)
		(self setMotion: 0 setCycle: 0)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 702 say: 3) ; "A blob of slime has gained an attraction for you. Is the green, viscous, congealed wad of bile helper bent on your destruction? Or is it just a friendly puddle of scum looking for a new friend? Dare you find out?"
			)
			(4 ; Do
				(switch (sewer status:)
					(4
						(HandsOff)
						(gNarrator modNum: 702 say: 4) ; "You bend down and scoop up some slime with both hands cupped."
						(gEgo
							setMotion: PolyPath (theSlime x:) (theSlime y:)
						)
					)
					(3
						(gNarrator modNum: 702 say: 5) ; "You're not close enough."
					)
					(else
						(gNarrator modNum: 702 say: 6) ; "You wave at the slime."
					)
				)
			)
			(13 ; jar
				(if (== ((Inv at: 5) cel:) 2) ; jar
					(gNarrator modNum: 702 say: 8) ; "You have all of that toxic spew that you wish to carry."
				else
					(Load rsVIEW 81)
					(Load rsSOUND 820)
					(switch (sewer status:)
						(4
							(gCurRoom setScript: scoopScript)
						)
						(3
							(switch gCurRoomNum
								(90
									(cond
										(
											(and
												(& (gEgo onControl: 1) $0002)
												(== (theSlime loop:) 0)
											)
											(cond
												((< (theSlime y:) 70)
													(gNarrator ; "Not quite yet... wait until it's in the right position!"
														modNum: 702
														say: 9
													)
												)
												((> (theSlime y:) 100)
													(gNarrator ; "Too late! You'd need longer arms to reach it from here."
														modNum: 702
														say: 10
													)
												)
												(else
													(gCurRoom
														setScript: scoopScript
													)
												)
											)
										)
										((> (sewer distance:) 10)
											(gNarrator modNum: 702 say: 11) ; "Either you or the slime will have to be in a different position for that.  Try waiting until it stops moving."
										)
										(else
											(switch (Random 0 1)
												(0
													(gNarrator ; "You are not quite close enough!"
														modNum: 702
														say: 13
													)
												)
												(1
													(gNarrator ; "Get just a little bit closer!"
														modNum: 702
														say: 12
													)
												)
											)
										)
									)
								)
								(95
									(cond
										(
											(and
												(& (gEgo onControl: 1) $0002)
												(== (theSlime loop:) 3)
											)
											(cond
												((< (theSlime y:) 60)
													(gNarrator ; "Not quite yet... wait until it's in the right position!"
														modNum: 702
														say: 9
													)
												)
												((> (theSlime y:) 110)
													(gNarrator ; "Too late! You'd need longer arms to reach it from here."
														modNum: 702
														say: 10
													)
												)
												(else
													(gCurRoom
														setScript: scoopScript
													)
												)
											)
										)
										((> (sewer distance:) 10)
											(gNarrator modNum: 702 say: 11) ; "Either you or the slime will have to be in a different position for that.  Try waiting until it stops moving."
										)
										(else
											(switch (Random 0 1)
												(0
													(gNarrator ; "You are not quite close enough!"
														modNum: 702
														say: 13
													)
												)
												(1
													(gNarrator ; "Get just a little bit closer!"
														modNum: 702
														say: 12
													)
												)
											)
										)
									)
								)
								(100
									(cond
										(
											(and
												(& (gEgo onControl: 1) $0002)
												(== (theSlime loop:) 1)
											)
											(cond
												((< (theSlime y:) 75)
													(gNarrator ; "Not quite yet... wait until it's in the right position!"
														modNum: 702
														say: 9
													)
												)
												((> (theSlime y:) 95)
													(gNarrator ; "Too late! You'd need longer arms to reach it from here."
														modNum: 702
														say: 10
													)
												)
												(else
													(gCurRoom
														setScript: scoopScript
													)
												)
											)
										)
										((> (sewer distance:) 10)
											(gNarrator modNum: 702 say: 11) ; "Either you or the slime will have to be in a different position for that.  Try waiting until it stops moving."
										)
										(else
											(switch (Random 0 1)
												(0
													(gNarrator ; "You are not quite close enough!"
														modNum: 702
														say: 13
													)
												)
												(1
													(gNarrator ; "Get just a little bit closer!"
														modNum: 702
														say: 12
													)
												)
											)
										)
									)
								)
								(115
									(if
										(and
											(& (gEgo onControl: 1) $0002)
											(> (theSlime y:) 105)
											(== (theSlime loop:) 1)
										)
										(gCurRoom setScript: scoopScript)
									else
										(gNarrator modNum: 702 say: 14) ; "The slime's already too far away! Perhaps it's a personal hygiene problem on your part."
									)
								)
								(105
									(if
										(and
											(& (gEgo onControl: 1) $0002)
											(> (theSlime y:) 105)
											(== (theSlime loop:) 0)
										)
										(gCurRoom setScript: scoopScript)
									else
										(gNarrator modNum: 702 say: 14) ; "The slime's already too far away! Perhaps it's a personal hygiene problem on your part."
									)
								)
								(else
									(switch (Random 1 4)
										(1
											(gNarrator modNum: 702 say: 15) ; "You are not in a good position for that."
										)
										(2
											(gNarrator modNum: 702 say: 16) ; "You can't do that from where you stand."
										)
										(3
											(gNarrator modNum: 702 say: 17) ; "Get closer."
										)
										(4
											(gNarrator modNum: 702 say: 18) ; "You're too far away to do that."
										)
									)
								)
							)
						)
						(else
							(gNarrator modNum: 702 say: 19) ; "That's not possible now."
						)
					)
				)
			)
			(7 ; Taste
				(gNarrator modNum: 702 say: 20) ; "You taste a tiny bit of the green slime. Instantly, several recent fillings dissolve into a puddle of silver amalgam."
			)
			(6 ; Smell
				(gNarrator modNum: 702 say: 21) ; "What were you expecting, Lime Slime? You notice a burning sensation when you get a strong whiff."
			)
			((OneOf theVerb 8 9 10 11 12 14 15 16 17 18 19 20 21 22 23) ; buckazoid, rope, bomb, rabbit, battery, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
				(gNarrator modNum: 702 say: 7) ; "That has no effect on the green slime!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scoopScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gNarrator modNum: 706 say: 12 self) ; "Okay."
			)
			(1
				(theSlime moveSpeed: 5)
				(= local0 1)
				(sewer status: 5)
				(= local1 (gEgo x:))
				(= local2 (gEgo y:))
				(gEgo
					normal: 0
					cycleSpeed: 12
					illegalBits: 0
					ignoreActors: 1
				)
				(cond
					((or (> (sewer angle:) 270) (< (sewer angle:) 20))
						(sewer scoopLoop: 3)
						(gEgo setLoop: -1 setHeading: 315 self)
					)
					((and (> (sewer angle:) 19) (< (sewer angle:) 100))
						(sewer scoopLoop: 4)
						(gEgo setLoop: -1 setHeading: 45 self)
					)
					((and (> (sewer angle:) 99) (< (sewer angle:) 190))
						(sewer scoopLoop: 1)
						(gEgo setLoop: -1 setHeading: 135 self)
					)
					((and (> (sewer angle:) 189) (< (sewer angle:) 271))
						(sewer scoopLoop: 0)
						(gEgo setLoop: -1 setHeading: 225 self)
					)
				)
			)
			(2
				(= register (gEgo loop:))
				(gEgo
					view: 81
					cel: 0
					cycleSpeed: 18
					setLoop: (sewer scoopLoop:)
					setCycle: CT 2 1 self
				)
			)
			(3
				(gLongSong vol: 127 number: 820 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo setMotion: MoveTo local1 local2 self)
			)
			(5
				(= cycles 5)
			)
			(6
				(SetScore 74 5)
				(= cycles 5)
			)
			(7
				(gLongSong number: 805 loop: -1 vol: 0 fade: 0 10 10 0)
				(= local66 0)
				(HandsOn)
				(gNarrator modNum: 702 say: 22) ; "You scoop up the slimy secretion. Better get away now before it scoops you up!"
				((gInventory at: 5) cel: 2 cursor: 953) ; jar
				((IconBar at: 6) cursor: 953)
				(NormalEgo register 0)
				(theSlime ignoreActors: 0 moveSpeed: (- gGameSpeed 2))
				(gLongSong2 vol: 127 number: 819 loop: -1 playBed:)
				(= seconds 3)
			)
			(8
				(= local0 0)
				(theSlime ignoreActors: 1)
				(sewer status: 4)
				(self dispose:)
			)
		)
	)
)

(instance thePipes of Sq4Feature
	(properties
		y 10
		nsBottom 200
		nsRight 320
		onMeCheck 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 702 say: 23) ; "The pipes running along the sides of this conduit are coated in inert slime."
			)
			(4 ; Do
				(gNarrator modNum: 702 say: 24) ; "You really don't want to touch the slime-laden pipes."
			)
			(7 ; Taste
				(switch (Random 0 1)
					(0
						(gNarrator modNum: 702 say: 25) ; "The pipes have the tangy taste of 100% real steel, basted with slime and rusted to a delicate crunch."
					)
					(1
						(gNarrator modNum: 702 say: 26) ; "The corrosive effect of the slimy pipes reduces your tongue to a stump. Now you truly are tasteless!"
					)
				)
			)
			(6 ; Smell
				(gNarrator modNum: 702 say: 27) ; "Your nostrils flare as you inhale the fragrant aroma of cold steel with just a hint of sewage."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theConduit of Sq4Feature
	(properties
		y 10
		nsBottom 200
		nsRight 320
		onMeCheck 34
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 702 say: 28) ; "This is a section of the Xenon sewer system. Fortunately, there seems to be very little of the secret ingredient usually associated with sewers."
			)
			(7 ; Taste
				(gNarrator modNum: 702 say: 29) ; "This rough area tastes strangely like blood. Oh, that IS blood. You shredded your tongue. Your mother should have warned you about licking strange areas!"
			)
			(6 ; Smell
				(switch (Random 0 1)
					(0
						(gNarrator modNum: 702 say: 30) ; "It smells like cotton candy, roses, and and fresh roasted peanuts. Yeah, right!"
					)
					(1
						(gNarrator modNum: 702 say: 31) ; "The stench lingering in this sewer reminds you of your clothes hamper!"
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theVent of Sq4Feature
	(properties
		y 10
		nsBottom 200
		nsRight 320
		onMeCheck 64
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 80 say: 1) ; "There's a small vent set into the side of the sewer tunnel. Unfortunately, it looks way too narrow for a space janitor, even a skinny one, to squeeze inside."
			)
			(7 ; Taste
				(gNarrator modNum: 702 say: 32) ; "Your tongue won't reach up there."
			)
			(6 ; Smell
				(gNarrator modNum: 702 say: 33) ; "Your nose isn't long enough to reach the vent."
			)
			(4 ; Do
				(gNarrator modNum: 702 say: 34) ; "You can't quite reach the vent."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theDrip1 of Sq4Prop
	(properties
		view 80
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 702 say: 35) ; "You see some dripping, oozing stuff."
			)
			(4 ; Do
				(gNarrator modNum: 702 say: 36) ; "There's nothing you could do with the dripping liquid."
			)
			(7 ; Taste
				(gNarrator modNum: 702 say: 38) ; "You don't really want to do that."
			)
			(6 ; Smell
				(gNarrator modNum: 702 say: 39) ; "It smells just like you thought it would."
			)
			((OneOf theVerb 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) ; buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
				(gNarrator modNum: 702 say: 37) ; "You don't need to do that."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theDrip2 of Sq4Prop
	(properties
		view 80
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gNarrator modNum: 702 say: 35) ; "You see some dripping, oozing stuff."
			)
			(4 ; Do
				(gNarrator modNum: 702 say: 36) ; "There's nothing you could do with the dripping liquid."
			)
			(7 ; Taste
				(gNarrator modNum: 702 say: 38) ; "You don't really want to do that."
			)
			(6 ; Smell
				(gNarrator modNum: 702 say: 39) ; "It smells just like you thought it would."
			)
			((OneOf theVerb 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) ; buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
				(gNarrator modNum: 702 say: 37) ; "You don't need to do that."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theSlimeScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== register 1) (< (sewer distance:) 20))
			(= register 0)
			(self init:)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(switch gCurRoomNum
					(75
						(= local62 8)
						(= local63 207)
					)
					(80
						(if (== (theSlime loop:) 2)
							(= local62 360)
							(= local63 91)
						else
							(= local62 158)
							(= local63 227)
						)
					)
					(85
						(= local62 311)
						(= local63 209)
					)
					(90
						(switch (theSlime loop:)
							(2
								(if (> (gEgo x:) (theSlime x:))
									(= local62 358)
									(= local63 89)
								else
									(= local62 192)
									(= local63 89)
								)
							)
							(else
								(if
									(and
										(< (gEgo y:) 50)
										(< (gEgo y:) (theSlime y:))
									)
									(= local62 274)
									(= local63 -8)
								else
									(= local62 30)
									(= local63 195)
								)
							)
						)
					)
					(95
						(switch (theSlime loop:)
							(2
								(switch gPrevRoomNum
									(100
										(if (< (gEgo x:) (theSlime x:))
											(= local62 218)
											(= local63 89)
										else
											(= local62 359)
											(= local63 89)
										)
									)
									(90
										(if (< (gEgo x:) (theSlime x:))
											(= local62 -40)
											(= local63 89)
										else
											(= local62 98)
											(= local63 89)
										)
									)
								)
							)
							(else
								(= local62 158)
								(= local63 220)
							)
						)
					)
					(100
						(switch (theSlime loop:)
							(2
								(if (< (gEgo x:) (theSlime x:))
									(= local62 -39)
									(= local63 91)
								else
									(= local62 120)
									(= local63 89)
								)
							)
							(else
								(= local62 312)
								(= local63 211)
							)
						)
					)
					(105
						(switch (theSlime loop:)
							(0
								(if (< (gEgo y:) (theSlime y:))
									(= local62 225)
									(= local63 -7)
								else
									(= local62 94)
									(= local63 111)
								)
							)
							(2
								(switch gPrevRoomNum
									(110
										(if (> (gEgo x:) (theSlime x:))
											(= local62 337)
											(= local63 125)
										else
											(= local62 118)
											(= local63 125)
										)
									)
									(else
										(= local62 337)
										(= local63 125)
									)
								)
							)
						)
					)
					(110
						(switch (theSlime loop:)
							(2
								(if (< (gEgo x:) (theSlime x:))
									(= local62 -30)
									(= local63 125)
								else
									(= local62 337)
									(= local63 125)
								)
							)
							(3
								(if (< (gEgo y:) (theSlime y:))
									(= local62 158)
									(= local63 -18)
								else
									(= local62 158)
									(= local63 109)
								)
							)
						)
					)
					(115
						(switch (theSlime loop:)
							(1
								(if (< (gEgo x:) (theSlime x:))
									(= local62 85)
									(= local63 -10)
								else
									(= local62 233)
									(= local63 113)
								)
							)
							(2
								(if (< (gEgo x:) (theSlime x:))
									(= local62 -36)
									(= local63 127)
								else
									(= local62 183)
									(= local63 127)
								)
							)
						)
					)
				)
				(theSlime
					setPri: 1
					setCycle: Fwd
					setMotion: MoveTo local62 local63 self
				)
			)
			(1
				(theSlime setCycle: Rev)
				(switch gCurRoomNum
					(80
						(self dispose:)
					)
					(90
						(cond
							((< (theSlime y:) 0)
								(sewer location: 75)
							)
							((== (theSlime loop:) 2)
								(theSlime setMotion: MoveTo 358 89 self)
							)
							(else
								(sewer location: 105)
								(theSlime dispose:)
								(self dispose:)
							)
						)
					)
					(95
						(if (== (theSlime loop:) 2)
							(if (== gPrevRoomNum 100)
								(theSlime setMotion: MoveTo 352 91 self)
							else
								(= register 1)
								(theSlime setMotion: MoveTo -32 89 self)
							)
						else
							(sewer location: 110)
							(theSlime posn: 1000 1000 dispose:)
							(self dispose:)
						)
					)
					(100
						(if (== (theSlime loop:) 2)
							(theSlime setMotion: MoveTo -30 89 self)
						else
							(if (< (gEgo y:) 100)
								(sewer location: 0 status: 0)
							else
								(sewer location: 115)
							)
							(theSlime dispose:)
							(self dispose:)
						)
					)
					(105
						(switch (theSlime loop:)
							(0
								(theSlime setMotion: MoveTo 139 70 self)
							)
							(2
								(switch gPrevRoomNum
									(110
										(if (== local62 118)
											(self init:)
										else
											(sewer location: 110 status: 6)
											(theSlime dispose:)
											(self dispose:)
										)
									)
									(else
										(= register 1)
										(theSlime
											setMotion: MoveTo 118 125 self
										)
									)
								)
							)
						)
					)
					(110
						(if (== (theSlime loop:) 3)
							(= register 1)
							(theSlime setMotion: MoveTo 158 -21 self)
						else
							(sewer location: 115 status: 6)
							(theSlime posn: 1000 1000 dispose:)
							(self dispose:)
						)
					)
					(115
						(switch (theSlime loop:)
							(2
								(theSlime setMotion: MoveTo -27 125 self)
							)
							(else
								(theSlime setMotion: MoveTo 191 82 self)
							)
						)
					)
					(else
						(theSlime dispose:)
						(self dispose:)
					)
				)
			)
			(2
				(switch gCurRoomNum
					(90
						(sewer location: 95)
						(theSlime dispose:)
						(self dispose:)
					)
					(100
						(sewer location: 95 status: 6)
						(theSlime dispose:)
						(self dispose:)
					)
					(105
						(= register 1)
						(theSlime setMotion: MoveTo 225 -7 self)
					)
					(110
						(if (== (theSlime loop:) 3)
							(if (or (< (gEgo x:) 60) (> (gEgo x:) 250))
								(sewer location: 0 status: 0)
							else
								(if (< (sewer distance:) 60)
									(sewer status: 6)
								)
								(sewer location: 95 rmTimer: 0)
							)
							(= register 0)
							(= cycles 1)
						)
					)
					(115
						(switch (theSlime loop:)
							(2
								(if
									(or
										(> (gEgo x:) 206)
										(< (gEgo y:) 114)
									)
									(sewer location: 0 status: 0)
								else
									(sewer
										location: 110
										prevDistance: (+ (gEgo x:) 25)
									)
								)
								(theSlime dispose:)
								(self dispose:)
							)
							(else
								(= register 1)
								(theSlime setMotion: MoveTo 87 -7 self)
							)
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(= register 0)
				(switch gCurRoomNum
					(95
						(sewer location: gPrevRoomNum)
					)
					(105
						(switch (theSlime loop:)
							(0
								(sewer location: 90 rmTimer: 0)
								(theSlime posn: 1000 1000)
							)
							(2
								(sewer location: 110)
							)
						)
					)
					(115
						(sewer location: 100)
						(cond
							((< (gEgo y:) 70)
								(sewer prevDistance: 1)
							)
							((< (gEgo y:) 105)
								(sewer prevDistance: 2)
							)
							((> (gEgo x:) 190)
								(sewer prevDistance: 3)
							)
							((> (Random 0 100) 50)
								(sewer status: 8)
							)
							(else
								(sewer prevDistance: 4)
							)
						)
					)
				)
				(theSlime dispose:)
				(self dispose:)
			)
		)
	)
)

