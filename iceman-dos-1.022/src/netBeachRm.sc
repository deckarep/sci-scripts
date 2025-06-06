;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	netBeachRm 0
)

(local
	local0
	local1
	local2
)

(instance netBeachRm of Rm
	(properties
		picture 55
		north 70
		east 46
		south 53
		west 53
	)

	(method (init)
		(super init:)
		(self setRegions: 305) ; scubaRg
		(LoadMany rsVIEW 152 455 155 54)
		(gEgo init:)
		(HandsOn)
		(switch gPrevRoomNum
			(53 ; antiSubNetRm
				(gEgo
					illegalBits: $8000
					posn: 10 135
					loop: 0
					setMotion: MoveTo 320 140
				)
			)
			(46 ; netToPierRm
				(gEgo
					illegalBits: $8000
					posn: 285 (gEgo y:)
					loop: 1
					setMotion: MoveTo -5 (gEgo y:)
				)
			)
			(else
				(gEgo
					illegalBits: $8000
					posn: 285 100
					loop: 1
					setMotion: MoveTo -5 (gEgo y:)
				)
			)
		)
		(if (not ((gInventory at: 4) ownedBy: 55)) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
			(net
				init:
				illegalBits: 0
				ignoreHorizon: 1
				ignoreActors: 1
				posn: 226 -20
				setScript: fishing 0 (Random 40 120)
			)
			(line
				init:
				illegalBits: 0
				ignoreHorizon: 1
				ignoreActors: 1
				posn: 225 -39
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (Said 'look>') (Said '[<around][/room][/water]'))
				(Print 45 0) ; "You are under water."
			)
		)
	)
)

(instance DV_3X of View
	(properties
		name {DV-3X}
		view 152
	)
)

(instance net of Act
	(properties
		view 455
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'bind,hide,adjust,drop,park/vehicle,diver')
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(Print 45 1) ; "You can't hide it here. It would be seen from the surface."
				else
					(Print 45 2) ; "You don't have it."
				)
			)
			((Said '/net>')
				(if local2
					(cond
						((Said 'look[<at]')
							(Print 45 3) ; "It appears to be a crab net."
						)
						((Said 'look[<in]')
							(if (== (net cel:) 1)
								(Print 45 4) ; "It now contains a bottle."
							else
								(Print 45 5) ; "It's empty."
							)
						)
						((Said 'get/net')
							(Print 45 6) ; "That would give away your presence."
						)
						((Said 'open/net')
							(Print 45 7) ; "That's not necessary."
						)
					)
				else
					(Print 45 8) ; "The net is not visible"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance line of Act
	(properties
		view 455
		loop 1
	)
)

(instance fishing of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((super handleEvent: event))
			((Said 'adjust/bottle')
				(cond
					((not local2)
						(Print 45 9) ; "You don't see a net."
					)
					((not (and (< 100 (gEgo x:) 300) (< 0 (gEgo y:) 120)))
						(Print 45 10) ; "Get closer to the net."
					)
					((and local0 (gEgo has: 4)) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
						(gEgo setScript: putBottle)
						(self dispose:)
					)
					((gEgo has: 4) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
						(Print 45 11) ; "You'll have to wait for the fishersman's net to be lowered."
					)
					(else
						(Print 45 12) ; "You don't have a bottle."
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles register)
			)
			(1
				(line setMotion: MoveTo 225 57)
				(= local2 1)
				(net setCel: 0 setMotion: MoveTo 226 86 self)
			)
			(2
				(= local0 1)
				(if (== local1 1)
					((gInventory at: 4) moveTo: 55) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
					(= local1 0)
				)
				(= cycles 200)
			)
			(3
				(= local0 0)
				(line setMotion: MoveTo 225 -49)
				(net setMotion: MoveTo 226 -20 self)
			)
			(4
				(= local2 0)
				(= cycles (Random 300 700))
			)
			(5
				(self changeState: 1)
			)
		)
	)
)

(instance putBottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 45 13) ; "You look around, making sure that nobody can see you as you put the bottle in the net."
				(gEgo ignoreActors: 1 illegalBits: 0)
				(cond
					((and (< (gEgo x:) 227) (< 85 (gEgo y:)))
						(self changeState: 1)
					)
					((and (< (gEgo x:) 227) (< (gEgo y:) 86))
						(self changeState: 4)
					)
					((and (< 226 (gEgo x:)) (< 85 (gEgo y:)))
						(self changeState: 2)
					)
					(else
						(self changeState: 3)
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 180 104 self)
			)
			(2
				(gEgo setMotion: MoveTo 247 104 self)
			)
			(3
				(gEgo setMotion: MoveTo 248 73 self)
			)
			(4
				(gEgo setMotion: MoveTo 195 73 self)
			)
			(5
				(gEgo setMotion: MoveTo 195 96 self)
			)
			(6
				(gEgo setMotion: MoveTo 226 96 self)
			)
			(7
				(gEgo
					view: 152
					viewer: 0
					setLoop: 5
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(DV_3X
						init:
						view: 155
						setLoop: 8
						setCel: 2
						setPri: (gEgo priority:)
						ignoreActors:
						posn: (+ (gEgo x:) 28) (- (gEgo y:) 3)
					)
				)
			)
			(8
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(9
				(net setCel: 1)
				(gEgo setCycle: Beg self)
				(= local1 1)
				(gGame changeScore: 1)
				(gEgo put: 4) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
			)
			(10
				(line setMotion: MoveTo 225 -49)
				(net setMotion: MoveTo 226 -20)
				(gEgo setLoop: 5 setCel: 4 setCycle: Beg self)
			)
			(11
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(DV_3X dispose:)
					(gEgo
						view: 54
						loop: 0
						setLoop: -1
						cel: 5
						setCycle: Walk
						cycleSpeed: 2
						ignoreActors: 0
						illegalBits: $8000
					)
				else
					(gEgo
						view: 154
						loop: 0
						setLoop: -1
						cel: 5
						setCycle: Walk
						cycleSpeed: 2
						ignoreActors: 0
						illegalBits: $8000
					)
				)
				(= local0 0)
				(net setScript: fishing 0 300)
				(HandsOn)
				(= cycles 30)
			)
			(12
				(= local2 0)
				(self dispose:)
			)
		)
	)
)

