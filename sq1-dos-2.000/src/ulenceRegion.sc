;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 702)
(include sci.sh)
(use Main)
(use Interface)
(use PAvoider)
(use PChase)
(use Feature)
(use MoveFwd)
(use Rev)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	ulenceRegion 0
	robot 1
)

(instance ulenceRegion of Rgn
	(properties)

	(method (init)
		(super init:)
		(if
			(and
				(!= (gLongSong number:) 601)
				(OneOf gCurRoomNum 40 41 42 45 46 47)
				(OneOf gPrevRoomNum 40 41 42 43 45 46 47 48)
			)
			(gLongSong number: 601 loop: -1 play:)
		)
		(if (IsFlag 33)
			(robot
				init:
				illegalBits: (if (OneOf gCurRoomNum 46 45) 64 else 0)
				posn:
					(switch (gEgo edgeHit:)
						(EDGE_LEFT
							(+ global163 319)
						)
						(EDGE_RIGHT
							(- global163 319)
						)
						(else
							(gEgo x:)
						)
					)
					(switch (gEgo edgeHit:)
						(EDGE_BOTTOM
							(- (gCurRoom horizon:) 10)
						)
						(EDGE_TOP 280)
						(else global164)
					)
				setLoop: roboGroop
				setCycle: Walk
				setMotion: PFollow gEgo 55
			)
			(gEgo setAvoider: PAvoider)
		)
		(mountains init:)
		(keronaSky init:)
		(bigMoon init:)
		(smallMoon init:)
		(radarPost init:)
		(desert init:)
	)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((== (gEgo onControl: 1) 16384)
				(gCurRoom setScript: zapEgo)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 45) (not (OneOf newRoomNumber 40 41 42 45 46 47)))
			(gLongSong fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(= global163 (robot x:))
		(= global164 (robot y:))
		(= keep (OneOf gNewRoomNum 40 41 42 44 45 46 47))
		(super dispose: &rest)
	)
)

(instance mountains of Feature
	(properties
		description {mountains}
		onMeCheck 128
		lookStr {In the distance is the galaxy-famous Skihairy mountain range. Nestled in its southernmost slopes is the renowned YoMammy National Park, usually hip-deep in tourists this time of year. Oh, well - maybe next trip.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 702 0) ; "You're not going to be able to feel anything from this distance."
			)
			(5 ; Talk
				(Print 702 1) ; "`Yodel-Ay-Hee-Hoo!' you call to the distant slopes. There is a slight delay, then a faint voice replies: `For pity's sake, fella - stop torturing that cat!'"
			)
			(12 ; Smell
				(Print 702 2) ; "The tourist brochures you've seen assure you that the air in YoMammy Park is clear, clean and refreshing. Compared to the atmosphere down here a weak solution of sulphuric acid would be pretty refreshing."
			)
			(11 ; Taste
				(Print 702 3) ; "I wouldn't advise walking around here with your tongue hanging out."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keronaSky of Feature
	(properties
		description {sky}
		onMeCheck 512
		lookStr {What a sky this planet has! You've never seen its like outside a toxic waste dump.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 702 4) ; "It's true, what they say - the air here is thick enough to feel."
			)
			(5 ; Talk
				(Print 702 5) ; "You shout into the sky, dislodging a chunk of Keronian atmosphere that narrowly misses your helmet."
			)
			(12 ; Smell
				(Print 702 6) ; "You detect a bit of sulfur in the air here as well. Can't get away from it on this planet, it appears."
			)
			(11 ; Taste
				(Print 702 7) ; "Don't lick the air. You're libel to get more than you bargained for."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bigMoon of Feature
	(properties
		description {big moon}
		onMeCheck 256
		lookStr {Kerona has two moons. This one's the bigger of two.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance smallMoon of Feature
	(properties
		description {small moon}
		onMeCheck 8192
		lookStr {Kerona has two moons. This one's the smaller of two.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance radarPost of Feature
	(properties
		description {radar post}
		onMeCheck 1024
		lookStr {The settlement of Ulence Flats is surrounded by these force field generators. They repel such undesirables such as the grell which thrive below the sands. It will allow only airborne vehicles in or out.}
	)

	(method (init)
		(= y (if (== gCurRoomNum 41) 200 else 0))
		(super init: &rest)
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(if (!= y 200)
			(= y ((User curEvent:) y:))
		)
		(super doVerb: &rest)
	)
)

(instance desert of Feature
	(properties
		description {desert}
		onMeCheck 2048
		lookStr {Kerona's relatively flat desert stretches out into the distance.}
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance robot of Actor
	(properties
		description {your pilot droid}
		lookStr {Your new pilot droid appears to be a bit dinged up, but functional. You hope that he knows more about piloting a spaceship than you do.}
		view 451
		signal 8192
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 702 8) ; "The droid emits a cheerful chirp, but has nothing further to say right now. Fortunately, you bought it as a pilot, not a conversationalist."
			)
			(3 ; Do
				(Print 702 9) ; "Although small, the NAV-201 is surprisingly heavy. You don't think you'll be able to lift it."
			)
			(4 ; Inventory
				(if (OneOf invItem 4 15) ; Knife, Widget
					(Print 702 10) ; "You wouldn't want to damage your droid. You wasted - I mean spent - much hardly-earned cash on it."
				else
					(super doVerb: theVerb invItem)
				)
			)
			(12 ; Smell
				(Print 702 11) ; "There's nothing like the smell of a new used droid."
			)
			(11 ; Taste
				(Print 702 12) ; "Like many things in your experience, it looks better than it tastes."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance roboGroop of Grooper
	(properties)
)

(instance zapEgo of Script
	(properties)

	(method (doit)
		(if (& (gEgo signal:) $0400)
			(self changeState: 3)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (or (< (++ global101) 4) (== gCurRoomNum 47))
					(gEgo
						view: 58
						cel: 0
						loop:
							(cond
								(
									(and
										(<= 0 (gEgo heading:) 90)
										(< (gEgo y:) 178)
									)
									0
								)
								((<= (gEgo heading:) 180) 4)
								((<= (gEgo heading:) 270) 5)
								(else 1)
							)
						setCycle: End self
					)
				else
					(gEgo
						view: 29
						cel: 0
						setLoop: (if (< (gEgo heading:) 180) 2 else 3)
						cycleSpeed: 7
						setCycle: End self
					)
				)
				(zapSound number: 602 loop: 1 play:)
				(zap
					init:
					cel: 0
					x: (gEgo x:)
					y: (- (gEgo y:) 32)
					setPri:
						(if (>= (gEgo loop:) 4)
							(+ (gEgo priority:) 1)
						else
							(- (gEgo priority:) 1)
						)
					setCycle: End
				)
			)
			(1
				(if (>= global101 4)
					(EgoDead 29 2 0 702 13) ; "Yikes! It looks like you hit that force field one too many times. Not only did it burn every follicle of hair from your sleek frame, but your aorta, if you could see it, now resembles the end of a red celery stalk."
				else
					(gEgo
						loop: (+ (gEgo loop:) 2)
						cel: 0
						setCycle: End self
					)
				)
			)
			(2
				(gEgo view: 1)
				(switch (gEgo loop:)
					(2
						(gEgo
							posn: (- (gEgo x:) 18) (+ (gEgo y:) 3)
							setLoop: 6
							heading: 225
						)
					)
					(3
						(gEgo
							posn: (+ (gEgo x:) 18) (+ (gEgo y:) 3)
							setLoop: 7
							heading: 135
						)
					)
					(6
						(gEgo
							posn: (- (gEgo x:) 11) (- (gEgo y:) 1)
							setLoop: 4
							heading: 325
						)
					)
					(7
						(gEgo
							posn: (+ (gEgo x:) 11) (- (gEgo y:) 1)
							setLoop: 5
							heading: 45
						)
					)
				)
				(gEgo setCycle: Rev setMotion: MoveFwd 10 self)
			)
			(3
				(= register (gEgo loop:))
				(NormalEgo 0 1 61)
				(gEgo loop: register)
				(zap dispose:)
				(if (not (IsFlag 38))
					(= cycles 8)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(4
				(Print 702 14) ; "Ouch! That hurt!"
				(Print 702 15) ; "You are standing next to the protective barrier encircling Ulence Flats. Due to the fact that you are land-based, you are not able to pass."
				(SetFlag 38)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance zap of Prop
	(properties
		view 58
		loop 8
		signal 24576
	)
)

(instance zapSound of Sound
	(properties
		number 602
	)
)

