;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use Language)
(use Feature)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm220 0
)

(local
	[local0 8] = [54 52 44 44 52 12 5 12]
	[local8 8] = [7 1 11 11 1 4 7 4]
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	[local28 5] = [3 4 0 2 1]
	[local33 5] = [2 4 3 0 1]
	[local38 3] = [3 4 5]
	[local41 5]
	[local46 5] = [1 2 4 8 16]
	[local51 5] = [{(A) Multiply.....} {(B) Apply CPU.....} {(C) It has square roots.....} {(D) To avoid short circuits.....} {(E) A cowculator.....}]
	[local56 5] = [{(A) \b6\b9\d9.....} {(B) CPU\b5\b3\b7\ad\b3 \c3\b1\c3\a6 \bd\d9.....} {(C) \bc\b6\b8\b2 \c8\b6\de \ca\b4\c3\b2\d9.....} {(D) \bc\ae\b0\c4\a6 \cc\be\b8\de\c0\d2.....} {(E) \b6\b3\b7\ad\da\b0\c0\b0.....}]
	[local61 20] = [{What's special about} {the way a robot plant} {grows?} {} {What kind of computer} {does a dairy farmer} {use?} {} {Why do robots always} {take the longest path} {between two points?} {} {What do robot rabbits} {do best?} {} {} {What should you do } {when a robot is } {having a heart attack?} {}]
	local81
)

(procedure (localproc_0 param1)
	(while (not (& global166 [local46 (= param1 (mod (++ param1) 5))]))
	)
	(return param1)
)

(procedure (localproc_1 &tmp temp0 [temp1 2])
	(if local26
		(if (not (< local17 local18))
			(= local17 (localproc_8 local19))
			(= local16 local19)
			(= local18 (StrEnd local17))
			(= local19 local20)
			(= local20 (localproc_0 local20))
		)
		(= temp0 0)
		(= local27 local22)
		(if (localproc_2 local17 local16)
			(DrawCel 225 8 0 14 89 15)
			(if (localproc_2 (localproc_8 local19) local19)
				(localproc_2 (localproc_8 local20) local20)
			)
		else
			(DrawCel 225 8 0 14 89 15)
		)
		(DrawCel 225 8 1 163 90 15)
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 30])
	(= temp4 0)
	(if [global403 [local28 param2]]
		(= temp0 [local0 0])
	else
		(= temp0 [local0 1])
	)
	(= temp1 (StrLen param1))
	(StrCpy @temp6 param1 temp1)
	(= temp2 1)
	(while
		(and
			(>=
				(= temp3 (localproc_3 @temp6 (proc0_3 4 200 200 200 200)))
				(- 171 local27)
			)
			temp1
		)
		(= temp2 0)
		(if (>= (= temp5 (/ (- (+ temp3 local27) 171) 7)) 1)
			(-= temp1 temp5)
		else
			(-- temp1)
		)
		(if (< temp1 0)
			(= temp1 0)
		else
			(StrCpy @temp6 param1 temp1)
		)
	)
	(++ temp3)
	(localproc_4 @temp6 temp0 local27 91 temp3)
	(+= local27 temp3)
	(if (not temp2)
		(Graph grUPDATE_BOX 91 local27 101 171 1)
	)
	(return temp2)
)

(procedure (localproc_3 param1 param2 &tmp [temp0 4])
	(TextSize @[temp0 0] param1 param2)
	(return [temp0 3])
)

(procedure (localproc_4 param1 param2 param3 param4 param5 &tmp temp0 temp1)
	(if (>= local27 (= temp0 22))
		(= temp0 local27)
	)
	(if (<= (+ local27 param5) (= temp1 163))
		(= temp1 (+ local27 param5))
	)
	(Graph grFILL_BOX 91 temp0 101 temp1 1 [local0 3] -1 -1)
	(Display
		param1
		dsCOORD
		param3
		param4
		dsCOLOR
		param2
		dsALIGN
		alLEFT
		dsFONT
		(proc0_3 4 200 200 200 200)
		&rest
	)
)

(procedure (localproc_5 &tmp temp0 temp1)
	(Graph grFILL_BOX 40 24 77 162 1 [local0 2] -1 -1)
	(= temp0 0)
	(= temp1 (* global402 4))
	(Graph grFILL_BOX 40 24 77 162 1 [local0 3] -1 -1)
	(Graph grUPDATE_BOX 40 24 77 162 1)
	(while (and (< temp0 4) (StrLen [local61 temp1]))
		(Display
			[local61 temp1]
			dsCOORD
			24
			(+ 40 (* temp0 10))
			dsCOLOR
			[local0 4]
			dsALIGN
			alLEFT
			dsFONT
			(proc0_3 4 200 200 200 200)
			&rest
		)
		(++ temp0)
		(++ temp1)
	)
)

(procedure (localproc_6 &tmp temp0 temp1 [temp2 80])
	(StrCpy @temp2 (localproc_8 local21))
	(for
		((= temp1 (StrLen @temp2)))
		(> (localproc_3 @temp2 gUserFont) 141)
		((-- temp1))
		
		(StrAt @temp2 temp1 0)
	)
	(Graph grFILL_BOX 91 22 101 163 1 [local0 3] -1 -1)
	(Graph grUPDATE_BOX 91 22 101 163 1)
	(for ((= temp0 0)) (< temp0 2) ((++ temp0))
		(proc5_8
			@temp2
			[local0 5]
			22
			91
			-1
			(proc0_3
				(proc0_3 4 200 200 200 200)
				gUserFont
				gUserFont
				gUserFont
				gUserFont
			)
		)
		(Wait 0)
		(Wait 20)
		(proc5_8
			@temp2
			[local0 6]
			22
			91
			-1
			(proc0_3
				(proc0_3 4 200 200 200 200)
				gUserFont
				gUserFont
				gUserFont
				gUserFont
			)
		)
		(Wait 20)
	)
	(= [global403 global402] 1)
	(if (< (++ global175) (+ global114 3))
		(if (>= global175 [local38 global114])
			(= local24 1)
			(robotJokes solvePuzzle:)
		)
		(while [global403 (= global402 (mod (++ global402) 5))]
		)
		(localproc_5)
	else
		(= local24 1)
		(robotJokes goAway:)
	)
)

(procedure (localproc_7)
	(proc5_9 220 20) ; "Sorry, human, that's not it."
)

(procedure (localproc_8 param1)
	(if (== (gGame printLang:) 1)
		(return [local51 param1])
	else
		(return [local56 param1])
	)
)

(instance rm220 of Rm
	(properties
		lookStr {This is the second floor hallway, the computer hall.}
		picture 220
		style 7
		south 200
	)

	(method (init &tmp temp0)
		(if (not (IsFlag 0))
			(for ((= temp0 0)) (< temp0 8) ((++ temp0))
				(= [local0 temp0] [local8 temp0])
			)
		)
		(if (not (IsFlag 41))
			(robotJokes init:)
		)
		(LoadMany rsSOUND 52 58 59 221 912 931 958 959)
		(super init:)
		(gCMusic number: 220 setLoop: -1 flags: 1 play:)
		(lightBulb init: stopUpd:)
		(lightedFloor init: hide:)
		(if (not (IsFlag 55))
			(leftDoor init: stopUpd:)
		else
			(lightedFloor show: stopUpd:)
			(leftDoorway init:)
		)
		(if (not (IsFlag 56))
			(rightDoor init: stopUpd:)
		else
			(rightDoorway init:)
		)
		(backDoor init: stopUpd:)
		(screen init: stopUpd:)
		(trashCan init:)
		(spears init:)
		(maceHead init: stopUpd:)
	)

	(method (dispose)
		(if (IsObject robotJokes)
			(robotJokes dispose:)
		)
		(gCMusic fade: 0 15 12 1)
		(gCMusic2 fade: 0 15 12 1)
		(super dispose: &rest)
	)
)

(instance leftDoorSound of Sound
	(properties
		flags 1
		number 912
	)
)

(instance rightDoorSound of Sound
	(properties
		flags 1
		number 931
	)
)

(instance leftDoor of Prop
	(properties
		x 67
		y 180
		description {left-hand door}
		sightAngle 180
		view 220
		cel 1
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 2)
				(Print 220 0) ; "Through the window you can see a maze. There is a robot moving through the maze."
			)
			((not (or (== theVerb 3) (and (== theVerb 4) (== invItem 8))))
				(super doVerb: theVerb &rest)
			)
			((gEgo has: 8)
				(SetFlag 55)
				(leftDoorSound play:)
				(self setScript: openLeftDoor)
			)
			(else
				(proc5_9 220 1) ; "You need a magnetic data card to open the door."
			)
		)
	)
)

(instance rightDoor of Prop
	(properties
		x 271
		y 34
		description {right-hand door}
		sightAngle 180
		view 220
		loop 4
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 220 2) ; "This high-tech door is labelled "Computer Room"."
			)
			(3
				(SetFlag 56)
				(rightDoorSound play:)
				(self setScript: openRightDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance screen of Prop
	(properties
		x 187
		y 50
		view 220
		loop 6
		priority 10
		signal 16
	)
)

(instance backDoor of Prop
	(properties
		x 177
		y 87
		description {back door}
		view 220
		loop 3
	)

	(method (doVerb theVerb invItem)
		(cond
			((== theVerb 2)
				(Print 220 3) ; "The console built into this door says "Robot Riddles"."
			)
			((== theVerb 3)
				(cond
					((not (gEgo has: 8))
						(proc5_9 220 4) ; "The data card is required to operate this console."
					)
					((IsFlag 41)
						(self setScript: openBackDoor)
					)
					(else
						(screen setScript: showJokes)
					)
				)
			)
			((and (== theVerb 4) (gEgo has: 8))
				(if (IsFlag 41)
					(self setScript: openBackDoor)
				else
					(screen setScript: showJokes)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance showJokes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (screen cel:))
					(screen setCycle: End self)
				else
					(= ticks 1)
				)
			)
			(1
				(if (robotJokes show:)
					(backDoor setScript: openBackDoor)
				)
				(self dispose:)
			)
		)
	)
)

(instance maceHead of Prop
	(properties
		x 141
		y 79
		description {mace head}
		view 220
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 220 5) ; "It's a spinning mace and flail. Better stay clear."
			)
			(3
				(if (self cycler:)
					(gCMusic2 stop:)
					(self setCycle: 0)
				else
					(gCMusic2 number: 221 flags: 1 setLoop: -1 play:)
					(self setCycle: Fwd)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bulbSound of Sound
	(properties
		flags 1
		number 58
	)
)

(instance lightBulb of Prop
	(properties
		x 93
		y 55
		description {light bulb}
		onMeCheck 16384
		view 220
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 220 6) ; "It's one of those capacitive, touch-controlled light bulbs."
			)
			(3
				(bulbSound play:)
				(if (self cel:)
					(gCMusic2 stop:)
					(maceHead setCycle: 0)
					(self setCel: 0)
				else
					(gCMusic2 number: 221 flags: 1 setLoop: -1 play:)
					(maceHead setCycle: Fwd)
					(self setCel: 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lightedFloor of Prop
	(properties
		x 81
		y 182
		view 220
		loop 5
		priority 14
		signal 16400
	)
)

(instance leftDoorway of Feature
	(properties
		description {doorway}
		onMeCheck 2
	)

	(method (onMe param1)
		(return (& onMeCheck (OnControl CONTROL (param1 x:) (param1 y:))))
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 3) (not (>= global176 (+ 3 global114))))
				(gCurRoom newRoom: 260)
			)
			((== theVerb 3)
				(proc5_9 220 7) ; "The robot has escaped from the maze. There's no reason to go back."
			)
			((and (== theVerb 2) (IsFlag 55))
				(proc5_9 220 8) ; "You can see the robot maze through the doorway"
			)
			(2
				(proc5_9 220 9) ; "Beyond this door lies the "Robot Maze"."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightDoorway of Feature
	(properties
		description {doorway}
		onMeCheck 4
	)

	(method (onMe param1)
		(return (& onMeCheck (OnControl CONTROL (param1 x:) (param1 y:))))
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 3) (not (IsFlag 17)))
				(gCurRoom newRoom: 240)
			)
			((== theVerb 3)
				(proc5_9 220 10) ; "The circuits are buzzing, and the computer is running. You don't need to go back."
			)
			((and (== theVerb 2) (IsFlag 56))
				(proc5_9 220 11) ; "Through the open doorway you can see the flashing lights and pulsating electrons of the "Computer Room"."
			)
			((== theVerb 2)
				(proc5_9 220 12) ; "This is the door to the "Computer Room"."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance openLeftDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leftDoor setCycle: Beg self)
				(lightedFloor show:)
			)
			(1
				(leftDoor stopUpd:)
				(proc5_9 220 13) ; "You open the door to the Robot Maze."
				(gCurRoom newRoom: 260)
				(self dispose:)
			)
		)
	)
)

(instance openBackDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(screen dispose:)
				(leftDoorSound play:)
				(backDoor setCycle: End self)
			)
			(1
				(proc5_9 220 14) ; "You've solved enough riddles that the robots think you're their kind of humanoid. The door opens."
				(gCurRoom newRoom: 280)
				(self dispose:)
			)
		)
	)
)

(instance openRightDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rightDoor setCycle: Beg self)
			)
			(1
				(proc5_9 220 15) ; "You open the door to the Computer Room."
				(gCurRoom newRoom: 240)
				(self dispose:)
			)
		)
	)
)

(instance rewardSound of Sound
	(properties
		flags 1
		number 52
	)
)

(instance robotJokes of PuzzleBar
	(properties
		puzzleHeight 124
		bottomHeight 0
		solvedFlag 41
	)

	(method (init &tmp temp0 temp1)
		(if global166
			(= local16 (localproc_0 -1))
			(= local17 (+ (localproc_8 local16) 1))
			(= local18 (StrEnd local17))
			(= local19 (localproc_0 local16))
			(= local20 (localproc_0 local19))
			(= local26 1)
		else
			(= local26 0)
		)
		(= window jokeWindow)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(if
				(or
					(not (& global166 [local46 temp0]))
					(& global401 [local46 temp0])
				)
				(= temp1 183)
			else
				(= temp1 179)
			)
			((= [local41 temp0] (clueIcon new:))
				nsLeft: (+ 19 (* temp0 15))
				loop: (+ temp0 1)
				maskLoop: (+ temp0 1)
				highlightColor: [local0 7]
				signal: temp1
			)
			(self add: [local41 temp0])
		)
		(self
			add:
				(nextIcon highlightColor: [local0 7] yourself:)
				(openIcon highlightColor: [local0 7] yourself:)
		)
		(= local24 0)
		(= local22 22)
		(super init: &rest)
	)

	(method (animateOnce &tmp temp0 temp1 temp2)
		(if (<= (-- local22) 14)
			(= temp1 (StrAt local17 0))
			(Format @temp2 220 16 temp1) ; "%c"
			(= temp0 (localproc_3 @temp2 (proc0_3 4 200 200 200 200)))
			(= local22 (+ 14 temp0))
			(++ local17)
			(localproc_1)
		else
			(localproc_1)
		)
		(return 1)
	)

	(method (show)
		(gCMusic2 stop:)
		(= local23 gTheCursor)
		(= local25 gSpeed)
		(= gSpeed 1)
		(gGame setCursor: 80)
		(super show: &rest)
		(= gSpeed local25)
		(if (maceHead cycler:)
			(gCMusic2 number: 221 flags: 1 setLoop: -1 play:)
		)
		(gGame setCursor: local23)
		(if local24
			(rewardSound play:)
			(Wait 30)
			(self solvePuzzle:)
		)
		(return local24)
	)

	(method (buyClue &tmp temp0)
		(= temp0 [local41 [local33 global402]])
		(cond
			((& (temp0 signal:) $0004)
				(proc5_9 220 17) ; "You need to learn the answer to this riddle from the robot maze before we can give you a hint. Of course, by then you won't NEED a hint!)"
			)
			((super buyClue: &rest)
				(robotJokes select: temp0 0)
			)
		)
	)

	(method (showHelp)
		(proc5_9 220 18) ; "This screen shows the state-of-the-art in sophisticated robot humor. (This is an art that has a long way to go!) You can answer the riddles with any of the answers stored on your data card. If you don't have enough answers, get the robot in the robot maze to find you some more."
		(proc5_9 220 19) ; "Select an answer by clicking on (or typing) its letter. To look at another riddle, click on the Next key, or press 'N'. To try to open the door, press 'O'."
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(if (== (= temp0 (event type:)) evKEYBOARD)
			(cond
				((and (>= (= temp1 (event message:)) KEY_a) (<= temp1 KEY_e))
					(= temp1 (+ (- temp1 97) 65))
					(robotJokes select: [local41 (- temp1 65)] 0)
				)
				((and (>= temp1 KEY_A) (<= temp1 KEY_E))
					(robotJokes select: [local41 (- temp1 65)] 0)
				)
				((or (== temp1 KEY_n) (== temp1 KEY_N))
					(robotJokes select: nextIcon 0)
				)
				((or (== temp1 KEY_o) (== temp1 KEY_O))
					(robotJokes select: openIcon 0)
				)
			)
		)
		(super dispatchEvent: event)
	)
)

(instance jokeWindow of SysWindow
	(properties
		top 17
		left 102
		bottom 176
		right 286
		back 43
		priority 14
	)

	(method (open)
		(super open:)
		(DrawCel 225 0 0 0 22 15)
		(localproc_5)
	)
)

(instance clueButtonSound of Sound
	(properties
		flags 1
		number 58
	)
)

(instance nextButtonSound of Sound
	(properties
		flags 1
		number 59
	)
)

(instance openButtonSound of Sound
	(properties
		flags 1
		number 59
	)
)

(instance clueIcon of CodeIcon
	(properties
		view 225
		cel 1
		nsTop 129
		maskView 225
		maskCel 3
	)

	(method (select)
		(if (super select:)
			(for
				((= local21 0))
				(and (< local21 5) (!= [local41 local21] self))
				((++ local21))
			)
			(clueButtonSound play:)
			(if (== global402 [local28 local21])
				(localproc_6)
				(|= global401 [local46 local21])
				(self signal: (| signal $0004) show:)
				(robotJokes advance:)
			else
				(localproc_7)
			)
		)
	)

	(method (highlight param1)
		(if (not (& signal $0004))
			(super highlight: param1 &rest)
		)
	)
)

(instance nextIcon of CodeIcon
	(properties
		view 225
		loop 6
		cel 1
		nsLeft 96
		nsTop 129
	)

	(method (select)
		(if (and (super select: &rest) (< global175 4))
			(while [global403 (= global402 (mod (++ global402) 5))]
			)
			(nextButtonSound play:)
			(localproc_5)
		)
	)
)

(instance openIcon of CodeIcon
	(properties
		view 225
		loop 7
		cel 1
		nsLeft 145
		nsTop 131
	)

	(method (select &tmp temp0)
		(openButtonSound play:)
		(if (and (super select: &rest) (>= global175 [local38 global114]))
			(= local24 1)
			(robotJokes goAway:)
		else
			(switch global114
				(0
					(= temp0 {three})
				)
				(1
					(= temp0 {four})
				)
				(2
					(= temp0 {all})
				)
			)
			(if 1
				(= global408 (Memory memALLOC_CRIT (StrLen temp0)))
				(= global409 (Memory memALLOC_CRIT (StrLen temp0)))
				(StrSplitInTwo global408 global409 temp0)
				(proc5_14 220 21 global408 global409) ; "You have to solve %s of the robot jokes before the door will open."
				(Memory memFREE global408)
				(Memory memFREE global409)
			)
		)
	)
)

(instance trashCan of Feature
	(properties
		x 121
		y 105
		nsTop 78
		nsLeft 105
		nsBottom 133
		nsRight 137
		description {trash can full of weapons}
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 220 22) ; "Dr. Brain doesn't believe in war or violence. That's why he threw out all these old weapons here."
			)
			(3
				(proc5_9 220 23) ; "Why, it's very nice of you to try to take out Dr. Brain's garbage. But the can is too heavy for you."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ouchSound1 of Sound
	(properties
		flags 1
		number 958
	)
)

(instance ouchSound2 of Sound
	(properties
		flags 1
		number 959
	)
)

(instance spears of Feature
	(properties
		x 134
		y 132
		z 84
		nsTop 30
		nsLeft 116
		nsBottom 66
		nsRight 152
		description {spears}
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 220 24) ; "Those spears really look sharp."
			)
			(3
				(gCurRoom setScript: spearSound)
				(proc5_9 220 25) ; "Ouch! That spear is really sharp. Better leave it alone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spearSound of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (> (++ local81) 2)
					(ouchSound2 play: self)
					(= local81 0)
				else
					(ouchSound1 play: self)
				)
			)
			(1
				(if (maceHead cycler:)
					(gCMusic2 number: 221 flags: 1 setLoop: -1 play:)
				)
				(self dispose:)
			)
		)
	)
)

