;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 603)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	waterReg 0
)

(local
	local0
	local1
	local2
	local3
)

(instance waterReg of Rgn
	(properties)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 10 11 12 13 14)
		(if (== global130 4)
			(= local3 1)
		)
		(self doit:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (gCurRoom script:))
				(OneOf (gEgo onControl: 1) 2 4 8 16)
			)
			(gCurRoom setScript: water)
		)
	)

	(method (handleEvent event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said 'swim<stop')
				(switch (gEgo view:)
					(13
						(Print 603 0) ; "There is no reason to stop swimming. You may drown."
					)
					(else
						(Print 603 1) ; "You cannot stop something you haven't started."
					)
				)
			)
			((or (Said 'swim/') (Said 'enter,go/water,lake,lake'))
				(cond
					(
						(and
							(== (gCurRoom script:) drowning)
							(>= (drowning state:) 3)
						)
						(Print 603 2) ; "It's too late now!"
					)
					((== global130 4)
						(Print 603 3) ; "You already are swimming."
					)
					(
						(or
							(& (gEgo onControl: 1) $0010)
							(& (gEgo onControl: 1) $0008)
						)
						(proc0_1)
						(= local3 1)
						(= global130 4)
						(= global136 1000)
						(gEgo view: 13 setCycle: Fwd)
						(gCurRoom setScript: water)
						(HandsOn)
					)
					(
						(or
							(& (gEgo onControl: 1) $0002)
							(& (gEgo onControl: 1) $0004)
						)
						(Print 603 4) ; "It's too shallow here."
					)
					((== global130 0)
						(Print 603 5) ; "You need to be in the water to swim."
					)
				)
			)
			((Said 'dive/')
				(cond
					((== global130 0)
						(Print 603 6) ; "You need to be in the water to try that."
					)
					(global130
						(cond
							((and (>= global130 1) (<= global130 3))
								(Print 603 7) ; "The water is not deep enough here for you to dive."
							)
							((& (gEgo onControl: 1) $0008)
								(Print 603 8) ; "The water isn't very deep here. Diving wouldn't be recommended."
							)
							(else
								(Print 603 9) ; "The water is very deep here. Without aid, it is impossible to swim under the water for any length of time."
							)
						)
					)
				)
			)
			((or (Said 'get,get/water') (Said 'fill/bucket'))
				(cond
					((not global130)
						(Print 603 10) ; "You are not close enough to the water."
					)
					((gEgo has: 8) ; Empty_Water_Bucket
						(if (IsFlag 9)
							(Print 603 11) ; "The bucket is already full of water."
						else
							(if (== global130 4)
								(Print 603 12) ; "With difficulty, you fill the bucket while swimming."
							else
								(Print 603 13) ; "You kneel down and fill the bucket with the cool water."
							)
							(UpdateWaterBucket 1)
						)
					)
					(else
						(Print 603 14) ; "You have nothing to carry the water in."
					)
				)
			)
		)
	)
)

(instance water of Script
	(properties)

	(method (init)
		(super init: &rest)
		(self doit:)
	)

	(method (doit)
		(if (and (IsFlag 1) (!= (gEgo onControl: 1) 1))
			(Print 603 15) ; "Walking in the water seems to have made you visible once again."
			(ClearFlag 1)
			(proc0_1)
		)
		(if
			(and
				(& (= local0 (gEgo onControl: 1)) $0018)
				(== global130 4)
				global136
				(not (-- global136))
			)
			(gCurRoom setScript: drowning)
		)
		(if (!= local0 local1)
			(= local1 local0)
			(cond
				((& local0 $0002)
					(if (== ((ScriptID 0 21) number:) 51) ; gameSound
						((ScriptID 0 21) stop:) ; gameSound
					)
					(= global130 1)
					(= local3 0)
					(gEgo setCycle: Walk view: 0 cycleSpeed: 0 moveSpeed: 0)
					(splash ignoreActors: init:)
				)
				((& local0 $0004)
					(if (== ((ScriptID 0 21) number:) 51) ; gameSound
						((ScriptID 0 21) stop:) ; gameSound
					)
					(= global130 2)
					(splash dispose:)
					(gEgo setCycle: Walk view: 11 cycleSpeed: 1 moveSpeed: 1)
					(= local3 0)
				)
				((& local0 $0008)
					(if (== ((ScriptID 0 21) number:) 51) ; gameSound
						((ScriptID 0 21) stop:) ; gameSound
					)
					(if (not local3)
						(gEgo
							setCycle: Walk
							view: 12
							cycleSpeed: 2
							moveSpeed: 2
						)
						(= local2 (gEgo loop:))
						(= global130 3)
					else
						(gEgo setCycle: Fwd)
					)
				)
				((& local0 $0010)
					(= global130 4)
					(= global136 1000)
					(gEgo view: 13 cycleSpeed: 0 moveSpeed: 0 setCycle: Fwd)
					((ScriptID 0 21) number: 51 loop: -1 play:) ; gameSound
				)
				((!= 0 local0 16384)
					(if (== ((ScriptID 0 21) number:) 51) ; gameSound
						((ScriptID 0 21) stop:) ; gameSound
					)
					(= global130 0)
					(= local3 0)
					(splash dispose:)
					(gEgo setCycle: StopWalk 2)
					(self dispose:)
				)
			)
		)
	)
)

(instance drowning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(= local2 (gEgo loop:))
				(gEgo
					setMotion: 0
					setLoop: 0
					view: 14
					cel: 5
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(gEgo cel: 5 setCycle: End self)
			)
			(2
				(gEgo cel: 5 setCycle: End self)
			)
			(3
				(gEgo hide:)
				(= seconds 4)
			)
			(4
				(if (not global136)
					(EgoDead
						{After swimming for a long time, your strength ebbs and your arms and legs grow weary.__As your life swims before your eyes, you decide to...}
					)
				else
					(EgoDead
						{You splash around for awhile, but unfortunately that won't keep your head above water.__As you go down for the third time, a sense of peace washes over you...}
					)
				)
			)
		)
	)
)

(instance splash of Prop
	(properties
		view 10
	)

	(method (doit)
		(self
			posn: (gEgo x:) (gEgo y:)
			cel: (gEgo cel:)
			loop: (gEgo loop:)
		)
		(super doit: &rest)
	)

	(method (doVerb))
)

