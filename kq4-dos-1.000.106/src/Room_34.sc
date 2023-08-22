;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room_34 0
)

(local
	local0
)

(instance Waves of List
	(properties)
)

(instance wave1 of Prop
	(properties)
)

(instance wave2 of Prop
	(properties)
)

(instance wave3 of Prop
	(properties)
)

(instance Room_34 of Rm
	(properties
		name {Room 34}
		picture 34
	)

	(method (init)
		(if gNight
			(= picture 134)
		)
		(= north 31)
		(= east 35)
		(= west 33)
		(= horizon 80)
		(= gIndoors 0)
		(= global108 horizon)
		(gEgo edgeHit: EDGE_NONE)
		(super init:)
		(self setRegions: 505 501 503 504) ; gfReg, waterReg, beachReg, Gull_Region
		(wave1
			view: 661
			isExtra: 1
			loop: 2
			cel: 0
			posn: 66 111
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave2
			view: 661
			isExtra: 1
			loop: 3
			cel: 0
			posn: 143 110
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave3
			view: 661
			isExtra: 1
			loop: 4
			cel: 0
			posn: 214 108
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(Waves add: wave1 wave2 wave3)
		(wave1 setScript: Wave_Actions)
		(switch gPrevRoomNum
			(31
				(gEgo posn: (gEgo x:) (+ horizon 2))
			)
			(33
				(gEgo posn: 2 (gEgo y:))
			)
			(35
				(gEgo posn: 317 (gEgo y:))
			)
		)
		(gEgo xStep: 2 yStep: 1 init:)
	)

	(method (dispose)
		(Waves dispose: delete:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look[<around][/room,island]'))
			(if (== (gEgo view:) 2)
				(Print 34 0) ; "You see the azure ocean stretching in front of you as you stand on the beach of this marvelous island. Behind you, set amidst a beautiful garden, rises a splendid ivory palace."
			else
				(Print 34 1) ; "You see the azure ocean stretching in front of you and the beach of a marvelous island. Set amidst a beautiful garden, rises a splendid ivory palace."
			)
		)
	)
)

(instance Wave_Actions of Script
	(properties
		name {Wave Actions}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local0 0)) (< local0 (Waves size:)) ((++ local0))
					((View new:)
						view: ((Waves at: local0) view:)
						loop: ((Waves at: local0) loop:)
						cel: 0
						setPri: 0
						ignoreActors:
						x: ((Waves at: local0) x:)
						y: ((Waves at: local0) y:)
						init:
						addToPic:
						yourself:
					)
				)
				(= local0 0)
				(self changeState: 1)
			)
			(1
				((Waves at: local0) cel: 0 show: setCycle: End self)
			)
			(2
				((Waves at: local0) hide:)
				(if (< local0 (- (Waves size:) 1))
					(++ local0)
				else
					(= local0 0)
				)
				(Wave_Actions changeState: 1)
			)
		)
	)
)

