;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 339)
(include sci.sh)
(use Main)
(use subMarine_314)
(use n330)
(use n331)
(use n332)
(use n333)
(use n334)
(use n335)
(use n396)
(use Submarine_806)
(use n821)
(use ForwardCounter)
(use Actor)
(use System)

(public
	battleShip1 0
	Class_339_0 1
)

(local
	[local0 12]
	[local12 16]
	local28
	local29
	local30
	[local31 6] = [0 1 2 3 4 5]
	[local37 8] = [0 1 2 3 4 5 6 7]
	local45
	local46
	local47
	[local48 2]
	local50
	local51
	local52
	local53
	local54 = 3
	local55
)

(procedure (localproc_0 &tmp temp0 temp1)
	(if local47
		(return 0)
	)
	(= temp1 0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(if
			(and
				[local12 temp0]
				(or
					(not (-- [local12 temp0]))
					(not (-- [local12 temp0]))
					(not (-- [local12 temp0]))
				)
			)
			([local12 (+ temp0 8)] setCel: 10)
			(= [local12 (+ temp0 8)] 0)
			(= temp1 1)
		)
	)
	(return temp1)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(if
			(and
				[local0 (+ temp0 6)]
				(!=
					([local0 (+ temp0 6)] cel:)
					(= temp1 (localproc_2 [local0 temp0]))
				)
			)
			([local0 (+ temp0 6)] setCel: temp1)
		)
	)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(if
			(and
				[local12 (+ temp0 8)]
				(!=
					([local12 (+ temp0 8)] cel:)
					(= temp1 (localproc_2 [local12 temp0]))
				)
			)
			([local12 (+ temp0 8)] setCel: temp1)
		)
	)
	(if (and local28 (!= (local28 cel:) (= temp1 (localproc_2 local45))))
		(local28 setCel: temp1)
	)
)

(procedure (localproc_2 param1 &tmp temp0)
	(= temp0 (Abs (/ param1 100)))
	(if (or (== param1 0) (< 9 temp0))
		(return 10)
	else
		(return temp0)
	)
)

(instance battleShip1 of Script
	(properties)

	(method (dispose)
		(proc0_3)
		(DisposeScript 956)
		(DisposeScript 396)
		(if (< state 10)
			(EgoDead 926 1 0 339 0) ; "Derelict of duty, you left your post."
		else
			(super dispose:)
			(DisposeScript 339)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== (event type:) $0400)
				(if (and local47 (!= (event message:) JOY_UP))
					(proc396_0 5 339 1) ; "SIR, ENEMY DESTROYER NOT SHOWING ON SONAR."
				else
					(switch (event message:)
						(JOY_NULL
							(if (event modifiers:)
								(if (/ local45 300)
									(proc396_0 5 339 2) ; "HARPOON MISSLE LAUNCHED, SIR."
									(proc334_0 (/ local45 4))
									(DisposeScript 334)
									(= local52 125)
								else
									(proc396_0 5 339 3) ; "THE DESTROYER IS TOO CLOSE FOR A MISSILE."
								)
							else
								(++ local50)
								(proc396_0 5 339 2) ; "HARPOON MISSLE LAUNCHED, SIR."
							)
						)
						(JOY_UP
							(proc396_0 5 339 4) ; "DECOY LAUNCHED, SIR."
							(++ local51)
						)
						(JOY_UPRIGHT
							(if (event modifiers:)
								(proc396_0 5 339 5) ; "STINGER LAUNCHED, SIR."
								(proc334_0 local45)
								(DisposeScript 334)
								(= local52 125)
							else
								(proc396_0 5 339 6) ; "SIR, MISSLE NOT LOCKED ON TARGET AND IT'S COMING AT US!"
								(proc331_0 300 0)
							)
						)
					)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(if (< 0 [local0 temp0])
				(-= [local0 temp0] 3)
				(if (== [local0 temp0] 0)
					(-- [local0 temp0])
				)
			)
		)
		(if (and (localproc_0) (< (Random 0 (+ local45 250)) 250))
			(++ local46)
			(target setCycle: ForwardCounter local54)
			(++ local54)
		)
		(if (and (not local47) (not script) (not (-- local45)))
			(self setScript: (ScriptID 328 0)) ; deadByDepthCharge
		)
		(if local52
			(-- local52)
		)
		(localproc_1)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1 [temp2 15])
		(switch (= state newState)
			(0
				(= local53 (gIceGlobalSound number:))
				(= local55 (gIceGlobalSound client:))
				(= local45 2500)
				(= local28 (bar1 init: stopUpd: yourself:))
				(= [local31 0] (torpedo0 init: yourself:))
				(= [local31 1] (torpedo1 init: yourself:))
				(= [local31 2] (torpedo2 init: yourself:))
				(= [local31 3] (torpedo3 init: yourself:))
				(= [local31 4] (torpedo4 init: yourself:))
				(= [local31 5] (torpedo5 init: yourself:))
				(= [local37 0] (torpedo6 init: yourself:))
				(= [local37 1] (torpedo7 init: yourself:))
				(= [local37 2] (torpedo8 init: yourself:))
				(= [local37 3] (torpedo9 init: yourself:))
				(= [local37 4] (torpedo10 init: yourself:))
				(= [local37 5] (torpedo11 init: yourself:))
				(= [local37 6] (torpedo12 init: yourself:))
				(= [local37 7] (torpedo13 init: yourself:))
				(blackHawk init:)
				(target init:)
				(= seconds 2)
			)
			(1
				(= start state)
				(proc331_0 local45 1)
				(DisposeScript 331)
				(= seconds 3)
			)
			(2
				(if local50
					(proc396_0 4 339 7) ; "THE HARPOON'S GOING OFF COURSE, SIR."
					(-- local50)
				)
				(if (< 2 local46)
					(= start 3)
					(proc396_0 4 339 8) ; "THE DESTROYER IS SINKING."
					(proc333_0)
					(DisposeScript 333)
					(local28 dispose:)
					(target hide: forceUpd: dispose: delete:)
					(= local28 0)
					(= local47 1)
					(= seconds 5)
				else
					(= cycles 2)
				)
			)
			(3
				(= seconds (proc332_0))
				(DisposeScript 332)
			)
			(4
				(= seconds (proc330_0))
				(DisposeScript 330)
			)
			(5
				(= temp0 0)
				(= temp1 1)
				(while (< temp0 6)
					(if (< [local0 temp0] 0)
						(cond
							((< 5 (Submarine hSpeed:))
								(self setScript: (ScriptID 329 0) 0 0) ; deadByTorpedo
							)
							((< (Submarine depth:) 500)
								(self setScript: (ScriptID 329 0) 0 3) ; deadByTorpedo
							)
							((& (Submarine flags:) $0080)
								(self setScript: (ScriptID 329 0) 0 1) ; deadByTorpedo
							)
							((not (& (Submarine flags:) $0040))
								(self setScript: (ScriptID 329 0) 0 2) ; deadByTorpedo
							)
							(local52
								(self setScript: (ScriptID 329 0) 0 4) ; deadByTorpedo
							)
							(else
								(= [local0 temp0] 0)
								([local0 (+ temp0 6)] setCel: 10)
								(= [local0 (+ temp0 6)] 0)
								(= temp1 4)
								(switch (Random 0 2)
									(0
										(proc396_0 3 339 9) ; "TORPEDO PASSING BY."
									)
									(1
										(proc396_0 3 339 10) ; "ONE TORPEDO SONAR FADING, SIR."
									)
									(2
										(gIceGlobalSound
											number: (proc0_5 20)
											loop: 1
											owner: gGame
											priority: 1
											play:
										)
										(ShakeScreen 30)
										(proc396_0 3 339 11) ; "TORPEDO MISSED, SIR."
									)
								)
							)
						)
					)
					(++ temp0)
				)
				(= seconds temp1)
			)
			(6
				(gIceGlobalSound
					number: local53
					loop: -1
					owner: gGame
					priority: 1
					play: local55
				)
				(if local51
					(-- local51)
					(if (proc335_0)
						(= seconds 4)
					else
						(= cycles 2)
					)
					(DisposeScript 335)
				else
					(= cycles 2)
				)
			)
			(7
				(if (not local47)
					(Format @temp2 339 12 (* local45 7)) ; "DESTROYER AT %d YARDS."
					(proc396_0 3 @temp2)
					(= seconds 4)
				else
					(= cycles 2)
				)
			)
			(8
				(= seconds (Random 1 2))
			)
			(9
				(if (and local47 (not local29))
					(proc396_0 4 339 13) ; "SIR, SONAR SILENT, COAST CLEAR."
					(blackHawk hide: forceUpd: dispose: delete:)
					(gGame changeScore: 5)
					(subMarine cue:)
					(= seconds 4)
				else
					(self init:)
				)
			)
			(10
				(proc396_0 4 339 14) ; "RADIO: THERE ARE CODED MESSAGES, SIR."
				(= seconds 45)
			)
			(11
				(self setScript: (ScriptID 327 0)) ; tooLong
			)
		)
	)
)

(instance blackHawk of View
	(properties
		y 65
		x 125
		view 527
		loop 9
		priority 14
		signal 273
	)
)

(instance target of Prop
	(properties
		y 39
		x 190
		view 527
		loop 7
		priority 14
		signal 16
	)
)

(instance bar1 of View
	(properties
		y 41
		x 195
		view 627
		loop 2
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo0 of View
	(properties
		y 43
		x 195
		view 627
		loop 1
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo1 of View
	(properties
		y 45
		x 195
		view 627
		loop 1
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo2 of View
	(properties
		y 47
		x 195
		view 627
		loop 1
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo3 of View
	(properties
		y 49
		x 195
		view 627
		loop 1
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo4 of View
	(properties
		y 51
		x 195
		view 627
		loop 1
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo5 of View
	(properties
		y 53
		x 195
		view 627
		loop 1
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo6 of View
	(properties
		y 66
		x 119
		view 627
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo7 of View
	(properties
		y 68
		x 119
		view 627
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo8 of View
	(properties
		y 70
		x 119
		view 627
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo9 of View
	(properties
		y 72
		x 119
		view 627
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo10 of View
	(properties
		y 74
		x 119
		view 627
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo11 of View
	(properties
		y 76
		x 119
		view 627
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo12 of View
	(properties
		y 78
		x 119
		view 627
		cel 10
		priority 14
		signal 273
	)
)

(instance torpedo13 of View
	(properties
		y 80
		x 119
		view 627
		cel 10
		priority 14
		signal 273
	)
)

(class Class_339_0
	(properties)

	(method (at param1 param2)
		(if (< 1 argc)
			(= [local0 param1] param2)
		else
			(return [local0 param1])
		)
	)
)

