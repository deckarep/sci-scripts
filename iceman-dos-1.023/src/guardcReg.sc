;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 306)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use n821)
(use Approach)
(use n954)
(use LoadMany)
(use Chase)
(use Grooper)
(use Sight)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	guardcReg 0
	caughtEgoScript 1
	guard 2
)

(local
	local0
	local1
	local2
	local3
)

(instance guardcReg of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 70 71 72)) ; fishermanBeachRm, tunaBeachRm1, tunaBeachRm2
		(= initialized 0)
		(super newRoom: &rest)
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 172 772 472 471 572)
		(guard illegalBits: $8040 setAvoider: Avoid setCycle: Walk init: hide:)
		(if (not local3)
			(= local3 20)
		)
		(cond
			((and (not (& (tunisia flags:) $0010)) (OneOf gCurRoomNum 71 72)) ; tunaBeachRm1, tunaBeachRm2
				(guard setScript: wrongBeachScript)
			)
			((and (not (& (tunisia flags:) $0010)) (!= (gEgo view:) 84))
				(tunisia flags: (| (tunisia flags:) $0010))
				(guard setScript: rm70ChaseScript)
			)
			(else
				(guard setScript: roomChaseScript)
				(= local0 (gEgo x:))
				(= local1 (gEgo y:))
				(= local2 (gEgo loop:))
			)
		)
	)
)

(instance wrongBeachScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(guard
					view: 172
					show:
					posn: 10 80
					setStep: 6 6
					setMotion: MoveTo 155 80 self
				)
			)
			(1
				(if (== gCurRoomNum 72) ; tunaBeachRm2
					(guard setMotion: MoveTo 175 80 self)
				else
					(= cycles 1)
				)
			)
			(2
				(self setScript: disMountScript self)
			)
			(3
				(guard setMotion: MoveTo (+ (gEgo x:) 30) (gEgo y:) self)
			)
			(4
				(guard setMotion: MoveTo (- (guard x:) 2) (guard y:) self)
			)
			(5
				(self setScript: arabicScript self)
			)
			(6
				(Print 306 0) ; "After questioning, you are unable to explain away the wet suit or provide identification."
				(gEgo heading: 270)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 6)
			)
			(7
				(gEgo view: 471 loop: 1 setCycle: End self)
				(guard view: 572 loop: 1 setCycle: End self)
			)
			(8)
			(9
				(gEgo
					setCycle: Walk
					setLoop: (+ (gEgo loop:) 2)
					setMotion: MoveTo (- (gEgo x:) 60) (gEgo y:) self
				)
				(guard
					setCycle: Walk
					setLoop: (+ (guard loop:) 2)
					setMotion: MoveTo (- (guard x:) 60) (guard y:)
				)
			)
			(10
				(EgoDead 970 0 0 306 1) ; "The guard places you under arrest and takes you away."
			)
		)
	)
)

(instance rm70ChaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 80)
			)
			(1
				(guard
					view: 172
					show:
					posn: 336 84
					observeControl: 64
					setStep: 6 6
					setMotion: MoveTo 237 84 self
				)
			)
			(2
				(self setScript: disMountScript self)
			)
			(3
				(guard illegalBits: $8040 setMotion: Chase gEgo 40 self)
			)
			(4
				(self setScript: arabicScript self)
			)
			(5
				(self setScript: caughtEgoScript)
			)
		)
	)
)

(instance roomChaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 (- (= seconds local3) 2))
			)
			(1
				(guard
					view: 472
					show:
					illegalBits: $8040
					posn: local0 local1
					setLoop: Grooper
					loop: local2
					setMotion: Chase gEgo 40 self
				)
			)
			(2
				(self setScript: arabicScript self)
			)
			(3
				(self setScript: caughtEgoScript)
			)
		)
	)
)

(instance caughtEgoScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(cond
					((and (gEgo has: 3) (not (gEgo has: 4))) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish, Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
						(Print 306 2) ; "The guard grabs the fish out of your hand and finds the map to your disguise."
						(= cycles 1)
					)
					((== (gEgo view:) 71)
						(Print 306 0) ; "After questioning, you are unable to explain away the wet suit or provide identification."
						(= cycles 1)
					)
					((gEgo has: 2) ; ID_Card
						(client setScript: hasIDScript)
					)
					(else
						(Print 306 3) ; "Unable to produce identification..."
						(= cycles 1)
					)
				)
			)
			(1
				(EgoDead 970 0 0 306 1) ; "The guard places you under arrest and takes you away."
			)
		)
	)
)

(instance hasIDScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 306 4) ; "The guard demands identification."
				(= cycles 1)
			)
			(1
				(Print 306 5) ; "Satisfied, the guard allows you to continue."
				(Print 306 6) ; "Whew," you think, "that was close!"
				(guardcReg setScript: guardLeaveScript)
				(HandsOn)
			)
		)
	)
)

(instance guardLeaveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gCurRoomNum
					(70 ; fishermanBeachRm
						(guard
							setMotion:
								Approach
								(if (< (guard y:) 90)
									(ScriptID 70 2) ; stupidAvoider2
								else
									(ScriptID 70 1) ; stupidAvoider
								)
								5
								self
						)
					)
					(71 ; tunaBeachRm1
						(guard
							setMotion:
								Approach
								(if (> (guard y:) 87)
									(ScriptID 71 2) ; stupidAvoider2
								else
									(ScriptID 71 1) ; stupidAvoider
								)
								5
								self
						)
					)
					(72 ; tunaBeachRm2
						(guard
							setMotion:
								Approach
								(if (> (guard y:) 91)
									(ScriptID 72 2) ; stupidAvoider2
								else
									(ScriptID 72 1) ; stupidAvoider
								)
								5
								self
						)
					)
				)
			)
			(1
				(guard dispose:)
				(self dispose:)
			)
		)
	)
)

(instance arabicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register 0)
					(HandsOff)
					(gEgo
						heading:
							(GetAngle
								(gEgo x:)
								(gEgo y:)
								(guard x:)
								(guard y:)
							)
					)
					((gEgo looper:) doit: gEgo (gEgo heading:))
				)
				(= cycles 6)
			)
			(1
				(if (== register 0)
					(guard
						heading:
							(GetAngle
								(guard x:)
								(guard y:)
								(gEgo x:)
								(gEgo y:)
							)
					)
					((guard looper:) doit: (guard) (guard heading:))
				)
				(= cycles 6)
			)
			(2
				(if (== register 0)
					(proc310_1 guard)
				)
				(= seconds 1)
			)
			(3
				(if (== register 0)
					(proc310_2)
					(Print 306 7) ; ""Halt," the guard yells."
				)
				(= cycles 2)
			)
			(4
				(proc310_1 guard)
				(= seconds 1)
			)
			(5
				(proc310_2)
				(proc310_1 gEgo)
				(= seconds 1)
			)
			(6
				(proc310_2)
				(= cycles 1)
				(if (<= (++ register) 3)
					(self init:)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance disMountScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard view: 772 cel: 0 illegalBits: 0 setCycle: End self)
			)
			(1
				(camel
					view: 772
					loop: (+ (guard loop:) 2)
					cel: 0
					posn: (guard x:) (guard y:)
					init:
				)
				(guard
					view: 472
					setLoop: Grooper
					setCycle: Walk
					setStep: 3 2
					posn: (camel x:) (+ (camel y:) 2)
				)
				(self dispose:)
			)
		)
	)
)

(instance guard of Act
	(properties
		view 172
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/guard,man]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(if (IsOffScreen self)
							(Print 306 8) ; "You don't see any guards, but you know they must be lurking around here somewhere."
						else
							(Print 306 9) ; "He's a mean guy with a large gun."
							(event claimed: 1)
						)
					)
					((Said 'talk')
						(if (IsOffScreen self)
							(event claimed: 0)
						else
							(Print 306 10) ; "He's not in the mood for conversation."
						)
					)
					((Said 'kiss,fuck,hug')
						(if (IsOffScreen self)
							(event claimed: 0)
						else
							(Print 306 11) ; "He'll rip your lungs out if you try anything like that!"
						)
					)
					((Said 'kill,shoot')
						(cond
							((IsOffScreen self)
								(event claimed: 0)
							)
							((gEgo has: 8) ; Sub: Device | Tunisia: Tranquilizer_Gun
								(Print 306 12) ; "You almost use the weapon but decide to save your limited ammo for the compound guards."
							)
							(else
								(Print 306 13) ; "You don't have a weapon."
							)
						)
					)
					((Said 'fight,kick,hit')
						(if (IsOffScreen self)
							(event claimed: 0)
						else
							(Print 306 14) ; "He's a mean guy with a large gun. You probably don't want to tangle with him."
						)
					)
					((Said 'greet')
						(if (IsOffScreen self)
							(event claimed: 0)
						else
							(Print 306 15) ; "He ignores your cheery salutation."
						)
					)
				)
			)
		)
	)
)

(instance camel of View
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/camel]>')
				(cond
					((IsOffScreen self))
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 306 16) ; "The camel, the ship of the desert."
					)
				)
			)
		)
	)
)

