;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Interface)
(use RandCycle)
(use Count)
(use Sort)
(use RFeature)
(use Rev)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm046 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 30] = [82 185 133 172 132 168 106 165 153 133 180 127 168 121 242 114 239 0 0 0 0 189 319 189 319 177 254 177 254 185]
	[local36 10] = [246 98 253 106 319 100 319 0 244 0]
)

(instance rm046 of Rm
	(properties
		picture 46
		north 44
		east 47
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (not (proc0_15 newRoomNumber 44 45 46))
			(gGlobalSound fade:)
		)
	)

	(method (init)
		(super init:)
		(if (!= (gGlobalSound number:) 7)
			(gGlobalSound number: 7 loop: -1 vol: 127 playBed:)
		)
		(proc0_24 128 624 626 628)
		(Load rsSCRIPT 751)
		(= global320 100)
		(= global321 140)
		(= global325 {"Come on, Graham! Let's explore someplace else!"})
		(self setFeatures: house beach bell setRegions: 220) ; boatRegion
		(gEgo posn: 0 500 illegalBits: $c000 init:)
		(switch gPrevRoomNum
			(112 ; hermit3
				(self setScript: cartoon2)
			)
			(east
				(if (and (not (IsFlag 55)) (not (gCurRoom script:)))
					(self setRegions: 202) ; owl
				)
			)
			(north
				(if (> (gEgo x:) 255)
					(gEgo show: posn: (gEgo x:) 125)
				else
					(gEgo show: posn: 255 125)
				)
				(gEgo setMotion: MoveTo (gEgo x:) 135 normal: 0)
				(if (not (IsFlag 55))
					(self setRegions: 202) ; owl
					(self setScript: (ScriptID 202 1)) ; stdWalkIn
				)
			)
			(else
				(gEgo show: posn: 255 125)
				(if (not (IsFlag 55))
					(self setRegions: 202) ; owl
				)
			)
		)
		(if (gCast contains: global322)
			(global322 setPri: 13)
		)
		(chimney init:)
		(if (== global81 3)
			(surf1 setScript: waves)
			(chimney setCycle: Fwd cycleSpeed: 3)
		)
		(if (and (not (and (IsFlag 72) (== global361 46))) (!= gPrevRoomNum 112)) ; hermit3
			(door init: setPri: 9)
		else
			(door init: setPri: 9 hide:)
			(hermit_a view: 626 posn: 131 148 setPri: 10 cel: 2 init:)
		)
		(if (== gPrevRoomNum east)
			(gEgo illegalBits: $c000)
		else
			(gEgo init: view: 0 normal: 1)
		)
		(poly1 points: @local6 size: 15)
		(poly2 points: @local36 size: 5)
		(self addObstacle: poly1 poly2)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(if (and (IsFlag 72) (not local2) (== global361 46))
					(= local2 1)
				)
				(script doit:)
			)
			(local2
				(= local2 0)
				(ClearFlag 72)
				(self setScript: bringCedric)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(if (and (gCast contains: global322) (!= temp0 47))
					((ScriptID 202 2) register: 2) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(SetFlag 108)
					(gCurRoom newRoom: temp0)
				)
			)
			((gEgo inRect: 234 100 257 115)
				(gEgo setMotion: 0)
				(if (gCast contains: global322)
					((ScriptID 202 2) register: 1) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(gCurRoom newRoom: 44)
				)
			)
			(
				(and
					(gCast contains: hermit_a)
					(== (hermit_a view:) 624)
					(> (gEgo distanceTo: hermit_a) 80)
				)
				(self setScript: hermitScared)
			)
			(
				(and
					(gCast contains: hermit_a)
					(== (hermit_a view:) 624)
					(< (gEgo distanceTo: hermit_a) 45)
				)
				(self setScript: hermitScared)
			)
			((and (& (gEgo onControl: 1) $2000) (!= (gEgo view:) 26))
				(gEgo view: 26)
			)
			((and (& (gEgo onControl: 1) $0001) (!= (gEgo view:) 0))
				(gEgo view: 0)
			)
			(local1
				(if
					(and
						(> local1 100)
						(== (hermit_a view:) 624)
						(gCast contains: hermit_a)
					)
					(= local1 0)
					(gCurRoom setScript: hermitScared)
				else
					(++ local1)
				)
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
		(DisposeScript 751)
		(DisposeScript 978)
		(gEgo ignoreControl: 16384)
		(super dispose:)
	)
)

(instance egoHeadMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) loop: (Random 4 6))
				(-- state)
				(= cycles 5)
			)
		)
	)
)

(instance cartoon2 of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 4) (== (gGlobalSound3 prevSignal:) -1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(hermit_a
					view: 626
					setCycle: Walk
					cycleSpeed: 0
					setLoop: -1
					ignoreActors: 1
					posn: 90 148
					illegalBits: 0
					show:
					init:
				)
				(= cycles 1)
			)
			(1
				(hermit_a setMotion: MoveTo 175 148)
				(= cycles 30)
			)
			(2
				(gEgo
					view: 624
					posn: 120 148
					normal: 1
					ignoreActors: 1
					illegalBits: 0
					setPri: -1
					setCycle: End self
					setLoop: 13
					setMotion: MoveTo 130 148 self --UNKNOWN-PROPERTY--
				)
			)
			(3
				((gEgo head:) hide:)
				(gEgo show: setCycle: Walk setMotion: MoveTo 130 148 self)
			)
			(4
				((gEgo head:) show:)
				(gEgo view: 0 setLoop: 0 setMotion: MoveTo 160 160)
				(hermit_a view: 628 setLoop: 2)
				(arm_a
					view: 628
					posn: (- (hermit_a x:) 5) (- (hermit_a y:) 32)
					setPri: (+ (hermit_a priority:) 1)
					setLoop: 1
					setCycle: CT 8 1
					init:
				)
				(gGlobalSound3 number: 821 loop: 1 vol: 127 play:)
			)
			(5
				(arm_a setCycle: End)
				(hermit_a setLoop: 2)
				(= seconds 5)
			)
			(6
				(mermaid
					init:
					setLoop: 8
					cycleSpeed: 2
					posn: 275 155
					setCycle: End self
				)
			)
			(7
				(mermaid setLoop: 7 cycleSpeed: 3 setCycle: Fwd)
				(= cycles 1)
			)
			(8
				(mouth
					init:
					setCycle: RandCycle
					setPri: (+ (hermit_a priority:) 1)
					setLoop: (mouth loop:)
					ignoreActors:
					cycleSpeed: 2
					posn: (+ (hermit_a x:) 3) (- (hermit_a y:) 37)
				)
				(PrintDC 46 0 #at 10 10 #dispose) ; "Pearl, this man needs your help. He needs you to lead him to Mordack's island. It's a real 'mergency. Mordack's holdin' his family hostage."
				(= seconds 10)
			)
			(9
				(mouth setCycle: 0)
				(cls)
				(= seconds 3)
			)
			(10
				(mouth setCycle: RandCycle)
				(PrintDC 46 1 #at 10 10 #dispose) ; "Pearl cain't speak human talk but she's agreed to help you. Just get on into your boat and folla her."
				(= seconds 7)
			)
			(11
				(mouth setCycle: 0)
				(cls)
				((gEgo head:) setCel: 1 setScript: egoHeadMove)
				(PrintDC 46 2 #at 100 10 #dispose) ; "I want to thank you for all your help, Mr....uh?"
				(= seconds 6)
			)
			(12
				((gEgo head:) setCel: 1 loop: 4 setScript: 0)
				(mouth setCycle: RandCycle)
				(cls)
				(PrintDC 46 3 #at 10 10 #dispose) ; "Don't worry about who I am. You just get on over to that there island and take care of your family."
				(= seconds 7)
			)
			(13
				(mouth setCycle: 0)
				(cls)
				((gEgo head:) setCel: 1 setScript: egoHeadMove)
				(PrintDC 46 4 #at 100 10 #dispose) ; "Thanks again for all your help."
				(= seconds 6)
			)
			(14
				((gEgo head:) setCel: -1 setScript: 0)
				(cls)
				(mermaid setLoop: 10 cycleSpeed: 2 setCycle: End self)
			)
			(15
				(mouth dispose:)
				(arm_a hide:)
				(hermit_a
					view: 626
					setCycle: Walk
					setLoop: 1
					cycleSpeed: 0
					ignoreActors: 1
					setMotion: MoveTo 90 144 self
				)
			)
			(16
				(door setCycle: Beg self show:)
				(gEgo setCycle: Walk setLoop: -1 view: 0)
				(NormalEgo)
			)
			(17
				(SetFlag 106)
				(gGlobalSound3 number: 124 vol: 50 loop: 1 play:)
				(gEgo setMotion: PolyPath 237 105 self)
			)
			(18
				(gCurRoom newRoom: 44)
			)
			(19
				(client setScript: 0)
			)
		)
	)
)

(instance bringCedric of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Say 96 46 5 67 10 10 25 8) ; "Came back, eh? Bring your friend on in here and I'll see if I can heal him up."
				(= cycles 1)
			)
			(1
				(cls)
				(= local4 1)
				(client setScript: cartoon)
			)
		)
	)
)

(instance waves of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(surf1
					init:
					show:
					setCycle: End self
					setPri: 2
					ignoreActors:
					cycleSpeed: (Random 5 10)
				)
				(surf2
					init:
					setCycle: RandCycle
					setPri: 2
					ignoreActors:
					cycleSpeed: (Random 5 10)
				)
			)
			(1
				(surf1 setCycle: Beg self)
				(surf2 setCycle: Beg)
			)
			(2
				(= seconds 5)
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance giveShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo put: 23) ; Shell
				(SetScore 4)
				(gEgo
					setCycle: Walk
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 186 149 self
				)
			)
			(1
				(gEgo setLoop: 1)
				(hermitHead hide:)
				(hermit_a
					view: 626
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 167 149 self
				)
			)
			(2
				(gEgo hide:)
				((gEgo head:) hide:)
				(hermit_a
					view: 624
					setLoop: 6
					cel: 0
					posn: 176 149
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(Say 104 46 6 67 20 20 25 3) ; "What's this?"
				(= cycles 1)
			)
			(4
				(cls)
				(gCurRoom setScript: cartoon)
			)
		)
	)
)

(instance dPush of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl: 1) $0001)
				(or (== (gEgo view:) 26) (== (gEgo view:) 28))
			)
			(gEgo view: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 135 147 self illegalBits: 0)
			)
			(1
				((gEgo head:) hide:)
				(gEgo view: 628 loop: 3 cycleSpeed: 1 setCycle: Fwd)
				(gGlobalSound3 number: 828 loop: -1 vol: 127 play:)
				(= seconds 4)
			)
			(2
				(gGlobalSound3 stop:)
				(++ local0)
				(PrintDC 46 7) ; "Graham pounds on the door, but finds it bolted from the inside. He can, however, hear activity within."
				(gEgo
					view: 0
					cel: 1
					cycleSpeed: 0
					setCycle: Walk
					ignoreActors: -32768
				)
				(= cycles 1)
			)
			(3
				((gEgo head:) show:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance myRotate of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global322 view: 138 loop: 1 setCycle: End self)
			)
			(1
				(global322 view: 138 loop: 4 cel: 7 setCycle: Beg self)
			)
			(2
				(client setScript: 0)
			)
		)
	)
)

(instance hermitScared of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(-- global362)
				(= cycles 1)
			)
			(1
				(Say 104 46 8 25 5 67 20 20) ; "Go away!"
				(= cycles 1)
			)
			(2
				(cls)
				(hermit_a
					view: 626
					setCycle: Walk
					cycleSpeed: 0
					setLoop: -1
					setCel: -1
					setMotion: MoveTo 105 148 self
				)
			)
			(3
				(hermit_a dispose:)
				(HandsOn)
				(= cycles 3)
			)
			(4
				(if (< global362 12)
					(++ global362)
				else
					(= global362 0)
				)
				(= cycles 1)
			)
			(5
				(door startUpd: ignoreActors: 0 setCycle: Beg self)
			)
			(6
				(gGlobalSound3 number: 124 vol: 50 loop: 1 play:)
				(door stopUpd:)
				(= cycles 1)
			)
			(7
				(client setScript: 0)
			)
		)
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local4
					(= state 5)
				)
				(= cycles 1)
			)
			(1
				(Hhead hide:)
				((gEgo head:) show:)
				(gEgo
					show:
					setCycle: Rev
					moveSpeed: 0
					setLoop: 1
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
				(hermit_a
					view: 624
					setLoop: 4
					posn: (- (gEgo x:) 19) (gEgo y:)
					setCycle: End
				)
				(shell init: signal: 22 setPri: (- (hermit_a priority:) 1))
			)
			(2
				(gEgo cel: 1 setCycle: 0)
				(= cycles 5)
			)
			(3
				(Say 96 46 9 67 10 20 25 4) ; "Now what were you wantin'?"
				(= cycles 1)
			)
			(4
				(cls)
				(if (IsFlag 56)
					(Say 160 46 10 67 100 10 25 5) ; "Can you tell me how to get to Mordack's island?"
					(= cycles 1)
				else
					(Say 160 46 11 67 100 10 25 5) ; "My owl friend is hurt. He was wounded by the harpies."
				)
				(= cycles 1)
			)
			(5
				(cls)
				(cond
					((IsFlag 56)
						(Say 96 46 12 67 10 10 25 7) ; "Eh? Too much noise out here! Come on inside where I can hear ya' better."
						(= state 8)
					)
					((!= global361 46)
						(Say 96 46 13 67 10 10 25 7) ; "Wounded by the harpies, did you say? Well, if you can bring him to me, I'll fix him right up...good as new!"
						(= state 10)
					)
					(else
						(Say 96 46 14 67 10 10 25 7) ; "Wounded by the harpies, did you say? Well, bring him on into the house. I'll fix him right up...good as new!"
					)
				)
				(= cycles 1)
			)
			(6
				(cls)
				(gEgo
					ignoreActors: 1
					setCycle: Walk
					cycleSpeed: 0
					setLoop: -1
					normal: 0
					illegalBits: 0
					setMotion: MoveTo 260 168 self
				)
			)
			(7
				(gEgo setLoop: 1)
				(= cycles 1)
			)
			(8
				((gEgo head:) hide:)
				(gEgo
					view: 624
					loop: 1
					posn: 260 155
					setPri: 15
					normal: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(9
				(cls)
				(shell dispose:)
				(hermit_a
					view: 626
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 0
					ignoreActors: 1
					setMotion: MoveTo 90 148
				)
				(gEgo
					setLoop: (if (IsFlag 56) -1 else 2)
					setPri: 10
					cycleSpeed: 0
					setCycle: Fwd
					normal: 0
					ignoreActors: 1
					setMotion: MoveTo 135 146 self
				)
			)
			(10
				(gEgo
					view: 624
					setLoop: (if (IsFlag 56) 14 else 11)
					setCycle: End self
				)
			)
			(11
				(cls)
				(if (== (hermit_a view:) 624)
					(shell dispose:)
					(hermit_a
						view: 626
						setLoop: -1
						setCycle: Walk
						cycleSpeed: 0
						ignoreActors: 1
						setMotion: MoveTo 90 148 self
					)
				else
					(gEgo setCycle: Walk setMotion: MoveTo 90 148 self)
				)
			)
			(12
				(door cycleSpeed: 2 setCycle: Beg self)
			)
			(13
				(gGlobalSound3 number: 124 vol: 50 loop: 1 play:)
				(client setScript: 0)
				(cond
					((IsFlag 56)
						(gCurRoom newRoom: 112) ; hermit3
					)
					((!= global361 46)
						(NormalEgo)
						(HandsOn)
						(SetFlag 72)
						(hermit_a dispose:)
						(= local1 0)
					)
					(else
						(gCurRoom newRoom: 111) ; hermit2
					)
				)
			)
		)
	)
)

(instance greeting of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl: 1) $0001)
				(or (== (gEgo view:) 26) (== (gEgo view:) 28))
			)
			(gEgo view: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: $8000
					ignoreActors: 1
					normal: 0
					setMotion: PolyPath 185 128 self
				)
			)
			(1
				(if (or (> global362 13) (< global362 0))
					(= global362 0)
				)
				(gEgo setMotion: PolyPath 177 129 self)
			)
			(2
				(gEgo setLoop: 7 setCel: 1)
				((gEgo head:) setLoop: 4)
				(arm_a
					init:
					posn: (- (gEgo x:) 4) (- (gEgo y:) 30)
					setCycle: CT 6 1 self
				)
			)
			(3
				(arm_a setCycle: End self)
				(gGlobalSound3 number: 819 loop: 1 vol: 127 play:)
			)
			(4
				(arm_a dispose:)
				(= seconds (Random 2 6))
			)
			(5
				((gEgo head:) setLoop: -1 cel: 2)
				(gEgo view: 0 loop: 7 cel: 2)
				(door startUpd: ignoreActors: 1 setCycle: End self)
				(gGlobalSound3 number: 122 vol: 75 loop: 1 play:)
			)
			(6
				(gEgo stopUpd:)
				(door stopUpd:)
				(hermit_a
					view: 626
					setCycle: Walk
					setMotion: MoveTo 131 148 self
					setPri: 10
					init:
				)
				(gGlobalSound2 number: 827 loop: 1 vol: 127 play:)
			)
			(7
				(hermit_a cel: 2)
				(RedrawCast)
				(= cycles 1)
			)
			(8
				(switch global362
					(0
						(Say 104 46 15 25 8 67 20 20) ; "Who are you? What are you doing on my beach?"
					)
					(1
						(Say 104 46 16 67 20 20 25 4) ; "You still here?"
					)
					(2
						(Say 104 46 17 67 20 20 25 4) ; "Whad'ya want?"
					)
					(3
						(Say 104 46 18 67 20 20 25 4) ; "Quit botherin' me!"
					)
					(4
						(Say 104 46 19 67 20 20 25 6) ; "Don't you know you're trespassin' on my beach?"
					)
					(5
						(Say 104 46 20 67 20 20 25 4) ; "Git outta here!"
					)
					(6
						(Say 104 46 21 67 20 20 25 4) ; "Leave me alone!"
					)
					(7
						(Say 104 46 22 67 20 20 25 4) ; "I cain't help ya!"
					)
					(8
						(Say 104 46 23 67 20 20 25 4) ; "Now what?!"
					)
					(9
						(Say 104 46 24 67 20 20 25 4) ; "Go away! Leave me alone!"
					)
					(10
						(Say 104 46 25 67 20 20 25 4) ; "Skedaddle. This ain't your beach!"
					)
					(11
						(Say 104 46 26 67 20 20 25 4) ; "Now whad'ya want?"
					)
					(12
						(Say 104 46 27 67 20 20 25 4) ; "I ain't interested."
					)
				)
				(= cycles 1)
			)
			(9
				(cls)
				(HandsOn)
				(gEgo normal: 1)
				(NormalEgo)
				(++ local1)
				(= cycles 1)
			)
			(10
				(client setScript: talkHermit)
			)
		)
	)
)

(instance talkHermit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo stopUpd:)
				(= local1 0)
				(switch global362
					(0
						(Say 160 46 28 67 100 10 25 9) ; "I am King Graham of Daventry and I'm on a journey to find the wizard Mordack's island. But I seem to be stuck; I don't know where to go from here."
					)
					(1
						(Say 160 46 29 67 100 10 25 4) ; "Please help me. I need your help."
					)
					(2
						(Say 160 46 30 67 100 10 25 4) ; "I just need some information."
					)
					(3
						(Say 160 46 31 67 100 10 25 4) ; "Do you know where the wizard Mordack lives?"
					)
					(4
						(Say 160 46 32 67 100 10 25 4) ; "I don't know where to go from here."
					)
					(5
						(Say 160 46 33 67 100 10 25 4) ; "Can you help me?"
					)
					(6
						(Say 160 46 34 67 100 10 25 5) ; "My family has been kidnapped by Mordack. I need to find him."
					)
					(7
						(Say 160 46 35 67 100 10 25 5) ; "You've got to help me!"
					)
					(8
						(Say 160 46 36 67 100 10 25 5) ; "Please! Take the time to listen to me."
					)
					(9
						(Say 160 46 37 67 100 10 25 5) ; "I need help to find Mordack's island."
					)
					(10
						(Say 160 46 38 67 100 10 25 5) ; "I think I'm lost. I need your help."
					)
					(11
						(Say 160 46 39 67 100 10 25 5) ; "I think you can help me...if you would only listen."
					)
					(12
						(Say 160 46 10 67 100 10 25 5) ; "Can you tell me how to get to Mordack's island?"
					)
				)
				(= cycles 1)
			)
			(1
				(cls)
				(= cycles 1)
			)
			(2
				(switch global362
					(0
						(Say 104 46 40 67 20 20 25 6) ; "Eh? What's that you say?"
					)
					(1
						(Say 104 46 41 67 20 20 25 4) ; "Eh? I cain't hear ya!"
					)
					(2
						(Say 104 46 42 67 20 20 25 4) ; "What's that you say?"
					)
					(3
						(Say 104 46 43 67 20 20 25 4) ; "What? Speak louder, boy!"
					)
					(4
						(Say 104 46 44 67 20 20 25 4) ; "Eh? What's that?"
					)
					(5
						(Say 104 46 45 67 20 20 25 4) ; "I cain't understand ya!"
					)
					(6
						(Say 104 46 46 67 20 20 25 4) ; "Gotta speak up, boy!"
					)
					(7
						(Say 104 46 47 67 20 20 25 4) ; "Eh?"
					)
					(8
						(Say 104 46 48 67 20 20 25 4) ; "What? I cain't understand!"
					)
					(else
						(Say 104 46 49 67 20 20 25 4) ; "I cain't hear ya! Speak up!"
					)
				)
				(= cycles 1)
			)
			(3
				(if (< global362 12)
					(++ global362)
				else
					(= global362 0)
				)
				(= cycles 1)
			)
			(4
				(HandsOff)
				(if (== global362 1)
					(Say 104 46 50 67 20 20 25 9) ; "Can't understand a thing you said. Gotta speak up boy! Now, get on outta here!"
				)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(User canControl: 0)
				(= seconds (if (gEgo has: 23) 7 else 1)) ; Shell
			)
			(6
				(HandsOff)
				(cls)
				(hermit_a
					view: 626
					illegalBits: 0
					setPri: 10
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 95 148 self
				)
			)
			(7
				(door startUpd: ignoreActors: 0 setCycle: Beg self)
				(gGlobalSound2 fade:)
			)
			(8
				(gGlobalSound3 number: 124 vol: 100 loop: 1 play:)
				(door stopUpd:)
				(HandsOn)
				(hermit_a dispose:)
				(= cycles 1)
			)
			(9
				(client setScript: 0)
			)
		)
	)
)

(instance house of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 46 51) ; "A makeshift house, fashioned from the bow of a wrecked ship, occupies the south end of a small, narrow beach."
					(event claimed: 1)
				)
				(3 ; Do
					(event claimed: 0)
				)
				(5 ; Inventory
					(switch global69
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 46 52) ; "Graham hasn't been invited into this house."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance beach of RFeature
	(properties
		nsTop 89
		nsLeft 242
		nsBottom 188
		nsRight 318
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (& (OnControl CONTROL (event x:) (event y:)) $2000))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0040))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0001))
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 46 53) ; "The ocean's cold water seems to lap hungrily toward the small "ship-house" built against the steep cliffs of the narrow beach."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance hermit_a of Act
	(properties
		name {hermit}
		y 148
		x 95
		view 626
		signal 1
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if (and (gCast contains: shell) (not (hermit_a mover:)))
			(switch (hermit_a cel:)
				(0
					(shell posn: (+ (hermit_a x:) 8) (- (hermit_a y:) 20))
				)
				(1
					(shell posn: (+ (hermit_a x:) 13) (- (hermit_a y:) 23))
				)
				(2
					(shell posn: (+ (hermit_a x:) 15) (- (hermit_a y:) 35))
				)
			)
		)
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
					(PrintDC 46 54) ; "An old hermit, ancient and fragile-looking, inhabits the makeshift "ship-house." It appears he has lived alone on this beach for many, many years."
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(23 ; Shell
							(gCurRoom setScript: giveShell)
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 46 55) ; "The hermit doesn't seem interested in that."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance door of Prop
	(properties
		y 147
		x 113
		view 625
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
					(not (proc0_18 self event))
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 46 56) ; "A crude door has been built into the side of the unusual house."
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 46 52) ; "Graham hasn't been invited into this house."
							(event claimed: 1)
						)
					)
				)
				(3 ; Do
					(if (event claimed: 1)
						(gCurRoom setScript: dPush)
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance bell of RFeature
	(properties
		y 94
		x 163
		z 32
		nsTop 88
		nsLeft 152
		nsBottom 102
		nsRight 173
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (proc0_18 self event))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0200))
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 46 57) ; "Graham notices a ship's bell near the door of the house."
					(event claimed: 1)
				)
				(3 ; Do
					(cond
						((gCast contains: hermit_a)
							(event claimed: 0)
						)
						((IsFlag 72)
							(event claimed: 0)
						)
						(else
							(gCurRoom setScript: greeting)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance hermitHead of Prop
	(properties
		view 628
		loop 2
		priority 15
		signal 1
	)
)

(instance chimney of Prop
	(properties
		y 70
		x 18
		z 20
		view 625
		loop 2
	)
)

(instance Hhead of Prop
	(properties
		view 628
		signal 16385
	)
)

(instance arm_a of Prop
	(properties
		name {arm}
		view 624
		loop 3
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

(instance surf1 of Prop
	(properties
		y 155
		x 284
		view 623
		loop 1
	)
)

(instance surf2 of Prop
	(properties
		y 181
		x 261
		view 623
		loop 2
	)
)

(instance hermit_b of Act ; UNUSED
	(properties
		name {hermit}
		signal 1
	)
)

(instance mermaid of Act
	(properties
		view 624
		signal 1
	)
)

(instance mouth of Prop
	(properties
		view 624
		loop 15
	)
)

(instance arm_b of Prop ; UNUSED
	(properties
		name {arm}
		view 628
	)
)

(instance shell of View
	(properties
		view 624
		loop 5
	)
)

