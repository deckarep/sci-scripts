;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	Room_70 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
)

(instance Room_70 of Rm
	(properties
		name {Room 70}
		picture 70
	)

	(method (init)
		(= gIndoors 1)
		(= local4 (Prop new:))
		(= local5 (Prop new:))
		(= local6 (Prop new:))
		(= local7 (Prop new:))
		(= local8 (Prop new:))
		(= local9 (Prop new:))
		(= local10 (Prop new:))
		(local4
			view: 668
			loop: 0
			cel: 2
			posn: 120 43
			setPri: 1
			setCycle: Fwd
			cycleSpeed: 1
			ignoreActors:
			init:
		)
		(local5
			view: 668
			loop: 1
			cel: 0
			posn: 171 40
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 1
			ignoreActors:
			init:
		)
		(local6
			view: 668
			loop: 2
			cel: 1
			posn: 142 98
			setPri: 6
			setCycle: Fwd
			cycleSpeed: 1
			ignoreActors:
			init:
		)
		(local7
			view: 668
			loop: 3
			cel: 1
			posn: 121 103
			setPri: 6
			setCycle: Fwd
			cycleSpeed: 1
			ignoreActors:
			init:
		)
		(local8
			view: 668
			loop: 4
			cel: 1
			posn: 131 123
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 1
			ignoreActors:
			init:
		)
		(local9
			view: 668
			loop: 5
			cel: 2
			posn: 105 123
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 1
			ignoreActors:
			init:
		)
		(local10
			view: 668
			loop: 6
			cel: 0
			posn: 145 119
			setPri: 0
			setCycle: Fwd
			cycleSpeed: 1
			ignoreActors:
			init:
		)
		(Load rsVIEW 7)
		(Load rsVIEW 8)
		(Load rsVIEW 377)
		(Load rsVIEW 378)
		(Load rsVIEW 680)
		(Load rsVIEW 21)
		(Load rsVIEW 10)
		(if (== gPrevRoomNum 24) ; Room_24
			(gEgo setScript: Ego_swims_in illegalBits: $8000)
		else
			(gEgo
				view: 2
				setStep: 2 1
				illegalBits: $8000
				posn: 225 114
				init:
			)
		)
		(if ((Inv at: 22) ownedBy: 70) ; Board
			(= local0 (View new:))
			(local0 view: 515 posn: 195 113 loop: 1 cel: 0 init: stopUpd:)
		)
		(super init:)
		(gEgo init:)
		(= global205 0)
	)

	(method (newRoom newRoomNumber)
		(HandsOn)
		(gEgo baseSetter: 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(= local2 (gEgo onControl: 1))
		(if (== (gEgo script:) 0)
			(cond
				(
					(or
						(gEgo inRect: 142 110 166 125)
						(gEgo inRect: 49 117 111 128)
					)
					(gEgo setScript: Ego_Swept)
				)
				((& local2 $0001)
					(= global105 0)
					(gEgo setCycle: Walk)
					(gEgo view: 2)
				)
				((& local2 $0800)
					(gEgo setCycle: Walk)
					(gEgo view: 7)
					(= global105 3)
				)
				((& local2 $0002)
					(gEgo view: 8)
					(= global105 4)
					(gEgo setCycle: Fwd)
				)
			)
			(if (gEgo inRect: 209 112 225 120)
				(gEgo baseSetter: (ScriptID 0 1)) ; smallBase
			else
				(gEgo baseSetter: 0)
			)
		)
		(if (& (gEgo onControl:) $0040)
			(gCurRoom newRoom: 71) ; TrollEnter
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/falls')
							(Print 70 0) ; "Waterfalls sure look different when you're underneath them!"
						)
						((Said '/cliff')
							(Print 70 1) ; "The mountain, above the waterfall, rises steeply to the east."
						)
						((Said '/cave')
							(Print 70 2) ; "It sure is dark in there!"
						)
						((Said '/boulder')
							(Print 70 3) ; "You see rocks all around you."
						)
						((Said '/flora')
							(Print 70 4) ; "You see only moss growing on the rocks."
						)
						((Said '/dirt')
							(if ((Inv at: 22) ownedBy: 70) ; Board
								(Print 70 5) ; "You see a board lying on the ground."
							else
								(Print 70 6) ; "You see nothing interesting on the ground."
							)
						)
						((Said '<under/water,pool')
							(if (== (gEgo view:) 2)
								(Print 70 7) ; "You're not in the water."
							else
								(Print 70 8) ; "You look under the water, and see nothing but...more water."
							)
						)
						((Said '<in,in/water,pool')
							(Print 70 9) ; "You look into the water, but see nothing of interest."
						)
						((Said '/falls')
							(Print 70 10) ; "It's difficult to see much of anything through a waterfall."
						)
						((Said '<in/pool,water')
							(Print 70 11) ; "You peer into the pool of water, but cannot see anything of importance."
						)
						((Said '/pool,water')
							(Print 70 12) ; "You see a deep pool below the waterfall."
						)
						((Said '[<around][/room]')
							(Print
								(Format ; "What's this?! Why, it's a cave behind the waterfall! %s"
									@global300
									70
									13
									(if ((Inv at: 22) ownedBy: 70) ; Board
										{You see an old board lying by the cave entrance.}
									else
										{}
									)
								)
							)
						)
					)
				)
				((Said 'climb/cliff')
					(Print 70 14) ; "The mountain is too steep to climb."
				)
				((Said 'climb/boulder')
					(Print 70 15) ; "You don't like to climb rocks."
				)
				((Said 'get/board')
					(if ((Inv at: 22) ownedBy: 70) ; Board
						(if (< (gEgo distanceTo: local0) 12)
							(gEgo setScript: Board_Actions)
							(Board_Actions changeState: 1)
							(gGame changeScore: 2)
						else
							(Print 800 1) ; "You're not close enough."
						)
					else
						(Print 70 16) ; "You already have it."
					)
				)
				((or (Said 'drink') (Said 'get/drink'))
					(if (== (gEgo view:) 2)
						(if
							(or
								(& (= local1 (NearControl gEgo 10)) $0008)
								(& local1 $0800)
								(& local1 $0002)
								(& local1 $0200)
							)
							(gEgo setScript: Drinking)
						else
							(Print 800 1) ; "You're not close enough."
						)
					else
						(Print 70 17) ; "You take a drink of the cool river water. Mmmmm. Not too bad."
					)
				)
				((Said 'get/water')
					(Print 70 18) ; "You have no reason to carry water."
				)
				((Said 'dive,bathe[<enter]')
					(if (== (gEgo view:) 2)
						(Print 70 19) ; "Just enter the water."
					else
						(Print 70 20) ; "You're already in the water."
					)
				)
			)
		)
	)
)

(instance Ego_swims_in of Script
	(properties
		name {Ego swims in}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 377
					posn: 158 120
					setCycle: Walk
					setMotion: MoveTo 167 123 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 167 123 self)
			)
			(2
				(gEgo setMotion: MoveTo 183 122 self)
			)
			(3
				(gEgo
					view: 378
					cel: 0
					setCycle: End
					setMotion: MoveTo 207 120 self
				)
			)
			(4
				((Sound new:) number: 59 play:)
				(= local3 (Prop new:))
				(local3
					view: 680
					posn: (gEgo x:) (gEgo y:)
					loop: 1
					setPri: (+ (gEgo priority:) 1)
					cel: 9
					setCycle: CT 2 -1 self
					init:
				)
			)
			(5
				(gEgo view: 2 setCycle: Walk)
				(local3 setCycle: Beg self)
			)
			(6
				(local3 dispose:)
				(Print 70 21 #draw) ; "It sure feels good to be yourself again!"
				(gEgo setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance Board_Actions of Script
	(properties
		name {Board Actions}
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(LookAt gEgo local0)
				(gEgo view: 21 cel: 0 setMotion: 0 setCycle: End self)
			)
			(2
				(= global182 1)
				(local0 dispose:)
				(gEgo get: 22) ; Board
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 2 setCycle: Walk)
				(HandsOn)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance Drinking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 21 cel: 0 setCycle: End self)
			)
			(1
				(Timer setReal: self 5)
				(Print 70 22 #at -1 20 #dispose) ; "You kneel down and take a drink of the cool river water. Mmmmm. Not too bad."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(gEgo view: 2 setCycle: Walk setScript: 0)
			)
		)
	)
)

(instance Ego_Swept of Script
	(properties
		name {Ego Swept}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global205 1)
				(if (gEgo inRect: 142 110 166 125)
					(gEgo setMotion: MoveTo 152 113)
				else
					(gEgo setMotion: MoveTo 80 118)
				)
				(gEgo view: 10 cel: 0 loop: 0 setCycle: End self)
			)
			(1
				(gEgo hide:)
				(gCurRoom newRoom: 24) ; Room_24
			)
		)
	)
)

