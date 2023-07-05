;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use Language)
(use IconBar)
(use Feature)
(use LoadMany)
(use Timer)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm440 0
)

(local
	[local0 3] = [31 19 29]
	[local3 3] = [31 19 29]
	[local6 6] = [{Help little girl find lost dog} {End war forever} {Take out the garbage} {Develop a cheap and reliable method of generating and using cold fusion} {Order pizza. Better make it a Large this time} {Make date for bridge game on TSN}]
	[local12 9] = [{Sex and the Single Scientist} {The Frankenstein Papers} {Gene-Splicing Made Easy} {Confessions of a Crazed Chemist} {The Search for Serotonin} {ABC's of Brain Transplants} {Evolutionary Creationism -- the Unified Theory} {A Simple Proof for Fermat's Last Theorem} {How to Disarm Nuclear Devices}]
	local21
	local22
	local23
	[local24 6] = [2 4 8 16 32 64]
	local30
	local31
	[local32 9]
	[local41 9]
	[local50 9]
	local59
	local60
	local61
	local62
	[local63 9] = [11 18 37 49 57 13 21 54 61]
	[local72 9] = [22 23 21 24 25 26 27 28 29]
	[local81 9] = [{timeliness} {mathematics} {programming} {cosmic consciousness} {pattern recognition} {language} {memory} {logic and deduction} {following instructions}]
	[local90 9] = [6 72 138 6 72 138 6 72 138]
	[local99 9] = [120 120 120 141 141 141 162 162 162]
	[local108 9] = [6 72 138 6 72 138 6 72 138]
	[local117 9] = [52 52 52 73 73 73 94 94 94]
	local126
	local127
	local128
	local129
	[local130 4]
	[local134 3]
	[local137 15]
	[local152 12]
	local164
	[local165 10] = [2 31 3 13 4 52 69 0 0 0]
	[local175 10] = [3 11 4 53 44 2 22 69 0 0]
	[local185 10] = [3 2 41 4 23 22 1 51 14 69]
	[local195 10]
	local205
	local206
	local207
	local208
	local209
	local210
	local211
	local212
	local213
	local214
	local215
	local216
	local217
	local218
	[local219 15] = [0 5 43 5 0 46 5 13 45 5 0 0 6 0 58]
	[local234 15] = [0 27 27 49 0 49 71 71 71 93 0 0 115 0 115]
	[local249 15] = [0 4 42 4 0 45 4 13 44 4 0 0 5 0 57]
	[local264 15] = [0 13 51 13 0 54 12 21 53 13 0 0 14 0 66]
	[local279 15] = [0 0 7 6 0 0 5 0 2 3 0 0 4 0 0]
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(cond
		((not param1)
			(= temp2 {choice})
			(= param1 (local59 value:))
		)
		((< param1 9)
			(= temp2 {button})
		)
		(else
			(= temp2 {button})
			(= temp3 1)
		)
	)
	(= temp0 0)
	(= temp1 0)
	(while (and (not temp1) (< temp0 18))
		(= temp1 (jobPuzzle at: temp0))
		(cond
			((!= (temp1 name:) temp2)
				(= temp1 0)
			)
			(temp3
				(if (& (temp1 signal:) $0004)
					(= temp1 0)
				)
			)
			((!= (temp1 value:) param1)
				(= temp1 0)
			)
		)
		(++ temp0)
	)
	(return temp1)
)

(procedure (localproc_1 &tmp temp0)
	(gTheIconBar select: (gTheIconBar at: 1) curIcon: (gTheIconBar at: 1))
	(gGame setCursor: 8)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3 temp4)
	(gCMusic2 number: 52 setLoop: 1 play:)
	(= local60 0)
	(= local61 0)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		(= temp2 (Random 0 8))
		(= temp3 (- 1 (* 2 (Random 0 1))))
		(= temp4 0)
		(while (<= temp4 8)
			(breakif (& ((= temp1 [local41 temp2]) signal:) $0004))
			(++ temp4)
			(if (> (+= temp2 temp3) 8)
				(= temp2 0)
			)
			(if (< temp2 0)
				(= temp2 8)
			)
		)
		(temp1
			signal: 128
			cel: 0
			loop: (+ temp0 1)
			maskCel: 2
			value: temp0
			show:
		)
	)
)

(procedure (localproc_3 param1 &tmp temp0)
	(= local61 0)
	(= local59 0)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		(= [local50 temp0] 0)
		(if local60
			([local32 temp0] loop: 0 cel: 3 signal: 133 value: temp0)
			([local41 temp0]
				loop: (+ temp0 1)
				cel: 1
				maskCel: 1
				signal: 128
				value: temp0
			)
		else
			([local32 temp0] cel: 1)
			([local41 temp0]
				loop: (+ ([local41 temp0] value:) 1)
				cel: 0
				signal: 128
			)
		)
		(if param1
			([local32 temp0] show:)
			([local41 temp0] show:)
		)
	)
)

(procedure (localproc_4 &tmp temp0)
	(= temp0 global114)
	(if (IsFlag 51)
		(+= temp0 3)
	)
	(proc5_9 20 (+ 17 temp0))
)

(procedure (localproc_5 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 15) ((++ temp0))
		(cond
			((not (= temp1 [local279 temp0]))
				(= [local137 temp0] 0)
			)
			((< temp1 5)
				([local130 (- temp1 1)]
					cel: 0
					nsTop: [local234 temp0]
					nsLeft: [local219 temp0]
					value: temp0
				)
				(= [local137 temp0] 1)
			)
			(else
				([local134 (- temp1 5)]
					cel: 0
					nsTop: [local234 temp0]
					nsLeft: [local219 temp0]
					value: temp0
				)
				(= [local137 temp0] 1)
			)
		)
		(if (< temp0 7)
			(= [local152 temp0] 0)
		)
	)
	(if [local130 0]
		([local130 0] nsLeft: 2 nsTop: 143 cel: 0 value: 15)
		(= [local152 0] 1)
	)
	(= local205 0)
	(= local129 0)
	(= local127 0)
	(localproc_1)
)

(instance rm440 of Rm
	(properties
		lookStr {This is Dr. Brain's office. You wonder how anyone could get any work done in here with the constantly ringing telephone, the fax machine whirring away, and the general mess. (Maybe that's why Dr. Brain ISN'T working in here!)}
		picture 440
		style 7
		south 420
	)

	(method (init &tmp temp0)
		(if (not (IsFlag 0))
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				(= [local0 temp0] [local3 temp0])
			)
		)
		(LoadMany rsSOUND 50 52 56 57 58 59 60 61 62 63 121 440 921 952 957)
		(LoadMany rsCURSOR 40 41 42 43 44 45 46 47 48)
		(LoadMany rsVIEW 450 451)
		(bookShelf init:)
		(patch init:)
		(phone init:)
		(teletype init:)
		(lightBulb init:)
		(if (not (gEgo has: 20))
			(ring init: hide:)
		)
		(drawer init:)
		(desk init:)
		(wasteBasket init:)
		(TTDBoard init:)
		(otherDeskDrawers init:)
		(blotter init:)
		(stapler init:)
		(lamp init:)
		(papersOnFloor init:)
		(pictureWindow init:)
		(mirror init:)
		(dart init:)
		(chair init:)
		(table init:)
		(jobSkills init:)
		(jobPuzzle init:)
		(bookPuzzle init:)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			((papers new:) init: onMeCheck: [local24 temp0])
		)
		(super init:)
		(gCMusic number: 440 setLoop: -1 flags: 1 play:)
		(gCMusic2 flags: 1)
		(teletypeS play:)
		(lightBulb setScript: lightChange)
		(teletype setCycle: Fwd)
		(phone setScript: phoneRinger)
	)

	(method (dispose)
		(if (IsObject jobPuzzle)
			(jobPuzzle dispose:)
		)
		(if (IsObject bookPuzzle)
			(bookPuzzle dispose:)
		)
		(gCMusic fade: 0 15 12 1)
		(super dispose: &rest)
	)
)

(instance papers of Feature
	(properties
		x 82
		y 276
		nsTop 23
		nsLeft 249
		nsBottom 82
		nsRight 303
		description {a piece of paper}
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(cond
			((== theVerb 3)
				(proc5_9 440 0)
			)
			((== theVerb 2)
				(= temp1 2)
				(for ((= temp0 0)) (not (& temp1 onMeCheck)) ((++ temp0))
					(<<= temp1 $0001)
				)
				(if 1
					(= global408 (Memory memALLOC_CRIT (StrLen [local6 temp0])))
					(= global409 (Memory memALLOC_CRIT (StrLen [local6 temp0])))
					(StrSplitInTwo global408 global409 [local6 temp0])
					(proc5_14 440 1 global408 global409)
					(Memory memFREE global408)
					(Memory memFREE global409)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bookShelf of Prop
	(properties
		x 98
		y 94
		description {bookshelf}
		view 440
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((== theVerb 3)
				(cond
					((not (IsFlag 38))
						(proc5_9 440 2)
					)
					((IsFlag 39)
						(self setScript: openShelf)
					)
					(else
						(if (!= local210 global114)
							(bookPuzzle dispose:)
							(bookPuzzle init:)
						)
						(bookPuzzle show:)
						(if (IsFlag 39)
							(self setScript: openShelf)
						)
					)
				)
			)
			((== theVerb 2)
				(switch local21
					(0
						(proc5_9 440 3)
					)
					(1
						(proc5_9 440 4)
					)
					(else
						(= temp0 (Random 0 8))
						(if 1
							(= global408 (Memory memALLOC_CRIT (StrLen [local12 temp0])))
							(= global409 (Memory memALLOC_CRIT (StrLen [local12 temp0])))
							(StrSplitInTwo global408 global409 [local12 temp0])
							(proc5_14 440 5 global408 global409)
							(Memory memFREE global408)
							(Memory memFREE global409)
						)
					)
				)
				(++ local21)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance openShelf of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
				(gCMusic2 number: 921 setLoop: -1 play:)
			)
			(1
				(gCMusic2 stop:)
				(proc5_11 440 6)
				(proc5_11 440 7)
				(proc5_11 440 8)
				(gEgo get: 2)
				(gCurRoom newRoom: 480)
			)
		)
	)
)

(instance patch of Prop
	(properties
		x 124
		y 156
		description {patch}
		view 440
		loop 1
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 3)
				(if (and cel (not cycler))
					(proc5_9 440 9)
				else
					(gCMusic2 number: 953 setLoop: 1 play:)
					(self setCycle: End)
					(chair
						lookStr:
							{Well, it WAS a nice chair!}
					)
				)
			)
			((== theVerb 2)
				(if cel
					(proc5_9 440 10)
				else
					(proc5_9 440 11)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance phone of Prop
	(properties
		x 249
		y 142
		description {telephone}
		view 440
		loop 5
		signal 4096
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 12) ; "The telephone keeps ringing. Why isn't Dr. Brain picking up the laboratory extension?"
			)
			((== theVerb 3)
				(if (not local31)
					(gCMusic2 number: 952 setLoop: 1 play:)
					(proc5_9 440 13)
					(gCMusic2 stop:)
				else
					(phoneS stop:)
					(self setCycle: 0 cel: 0 setScript: phoneRinger)
					(= local31 0)
					(switch local22
						(0
							(proc5_14 440 14)
						)
						(1
							(proc5_14 440 15)
						)
						(2
							(proc5_14 440 16)
						)
						(3
							(proc5_14 440 17)
						)
						(else
							(proc5_14 440 18)
						)
					)
					(++ local22)
					(self setScript: phoneRinger)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance phoneRinger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(= cycles (Random 100 200))
			)
			(1
				(if (and (== (gCMusic2 number:) 952) (gCMusic2 handle:))
					(phone setScript: self)
				else
					(= local31 1)
					(phoneS play:)
					(client setCycle: End self)
				)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(phoneS stop:)
				(= ticks 30)
			)
			(4
				(++ register)
				(if (<= register 3)
					(self changeState: 1)
				else
					(= local31 0)
					(phone setScript: self)
				)
			)
		)
	)
)

(instance teletype of Prop
	(properties
		x 21
		y 146
		description {fax machine}
		view 440
		loop 4
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 19) ; "Dr. Brain's fax machine is continually spewing out pages of scientific research results, incredible discoveries, stock market quotes, and sports scores. (Dr. Brain seems to be especially interested in the Pro Bowling Tour.)"
			)
			((== theVerb 3)
				(proc5_9 440 20)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lightBulb of Prop
	(properties
		x 282
		y 91
		description {lamp}
		view 440
		loop 2
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(gCMusic2 number: 61 setLoop: 1 play:)
			(self setCel: (- 1 cel))
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lightChange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 300 600))
			)
			(1
				(gCMusic2 number: 61 setLoop: 1 play:)
				(lightBulb setCel: (- 1 (lightBulb cel:)))
			)
			(2
				(lightBulb setScript: self)
			)
		)
	)
)

(instance drawer of Prop
	(properties
		x 222
		y 154
		description {desk drawer}
		view 440
		loop 3
		signal 4096
	)

	(method (doVerb theVerb invItem)
		(cond
			((and (== theVerb 4) (== invItem 17))
				(gEgo put: 17)
				(self setScript: openDrawer)
				(= local23 1)
			)
			((== theVerb 3)
				(if local23
					(if cel
						(if (not (gEgo has: 20))
							(ring x: 222 y: 154 setLoop: 6)
							(ring cel: (ring lastCel:) setCycle: Beg)
						)
						(self setCycle: Beg)
						(gCMusic2 number: 121 setLoop: 1 play:)
					else
						(self setScript: openDrawer)
					)
				else
					(proc5_9 440 21)
				)
			)
			((== theVerb 2)
				(cond
					((not cel)
						(proc5_9 440 22)
					)
					((gEgo has: 20)
						(proc5_9 440 23)
					)
					(else
						(proc5_9 440 24)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance openDrawer of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
				(if (not (gEgo has: 20))
					(ring show: setCycle: End)
				)
				(gCMusic2 number: 121 setLoop: 1 play:)
			)
			(1
				(if (not (gEgo has: 20))
					(ring setLoop: 8 setCel: 0 x: 166 y: 131)
					(proc5_9 440 25)
				)
				(self dispose:)
			)
		)
	)
)

(instance ring of Prop
	(properties
		x 222
		y 154
		description {decoder ring}
		view 440
		loop 6
		priority 12
		signal 16
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 3)
			(if (> loop 6)
				(gCMusic2 number: 59 setLoop: 1 play:)
				(gEgo get: 20)
				(= local30 1)
				(self dispose:)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance jobSkills of Feature
	(properties
		nsTop 37
		nsLeft 119
		nsBottom 78
		nsRight 222
		description {job skills board}
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 26) ; "This board is labelled "Job Skills", and looks like a giant job application."
			)
			((== theVerb 3)
				(cond
					((IsFlag 38)
						(proc5_9 440 27)
					)
					((jobPuzzle show:)
						(jobPuzzle dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		nsTop 96
		nsLeft 158
		nsBottom 189
		nsRight 303
		description {desk}
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 28) ; "Dr. Brain's desk looks impressive, imposing, and seldom-used (except for eating pizza)."
			)
			((== theVerb 3)
				(proc5_9 440 29)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		nsTop 91
		nsLeft 263
		nsBottom 128
		nsRight 290
		description {lamp}
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 30) ; "This cute little lamp looks like a penguin. It shows the same degree of artistic taste as evidenced by the lawn flamingos."
			)
			((== theVerb 3)
				(gCMusic2 number: 61 setLoop: 1 play:)
				(lightBulb setCel: (- 1 (lightBulb cel:)))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wasteBasket of Feature
	(properties
		nsTop 158
		nsLeft 242
		nsBottom 189
		nsRight 295
		description {trash can}
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 31) ; "The trash can is totally full of old papers, magazines, and newspapers. At least these aren't out on the floor!"
			)
			((== theVerb 3)
				(proc5_9 440 32)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		nsTop 76
		nsLeft 85
		nsBottom 189
		nsRight 167
		description {comfy chair}
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(Print 440 33) ; "This overstuffed chair looks as though it's seen better days, but it is still very comfortable."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance table of Feature
	(properties
		nsTop 115
		nsBottom 189
		nsRight 70
		description {table}
		onMeCheck 4096
	)
)

(instance jobPuzzle of PuzzleBar
	(properties
		puzzleHeight 161
		bottomHeight 0
		solvedFlag 38
	)

	(method (init &tmp temp0)
		(= window jobWindow)
		(= local126 23)
		(= local60 1)
		(= local61 0)
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(self
				add:
					((= [local32 temp0] (choice_GAuswahl new:))
						loop: 1
						nsLeft: [local108 temp0]
						nsTop: [local117 temp0]
						highlightColor: [local0 0]
						lowlightColor: [local0 1]
						value: temp0
						yourself:
					)
			)
		)
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(self
				add:
					((= [local41 temp0] (button_GKnopf new:))
						loop: (+ temp0 1)
						nsLeft: [local90 temp0]
						nsTop: [local99 temp0]
						highlightColor: [local0 0]
						value: temp0
						yourself:
					)
			)
		)
		(self add: lastIcon)
		(super init: &rest)
	)

	(method (show)
		(phoneS fade:)
		(teletypeS fade:)
		(super show: &rest)
		(if local62
			(self solvePuzzle: 2)
			(proc5_9 440 6)
			(proc5_9 440 34)
		)
		(phoneS vol: 127)
		(teletypeS vol: 127)
		(return local62)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (== (= temp0 (event type:)) evKEYBOARD)
			(= temp1 (event message:))
			(= temp2 0)
			(cond
				((== temp1 KEY_ADD)
					(= temp2 1)
				)
				((== temp1 KEY_SUBTRACT)
					(= temp2 2)
				)
				((or (== temp1 KEY_x) (== temp1 KEY_X))
					(= temp2 3)
				)
				((== temp1 KEY_DIVIDE)
					(= temp2 4)
				)
			)
			(if temp2
				(self select: (self at: (-- temp2)) 0)
			)
		)
		(if (and (& temp0 $0040) (IsObject highlightedIcon)) ; direction
			(switch (= temp3 (event message:))
				(JOY_UP
					(= temp5 (self indexOf: highlightedIcon))
					(= temp4
						(self
							at: (= temp5 (- (self indexOf: highlightedIcon) 2))
						)
					)
					(highlightedIcon highlight: 0)
					(self highlightedIcon: temp4)
					(self retreat:)
				)
				(JOY_DOWN
					(= temp5 (self indexOf: highlightedIcon))
					(= temp4
						(self
							at: (= temp5 (+ (self indexOf: highlightedIcon) 2))
						)
					)
					(highlightedIcon highlight: 0)
					(self highlightedIcon: temp4)
					(self advance:)
				)
			)
		)
		(super dispatchEvent: event)
	)

	(method (showHelp)
		(proc5_9 440 35)
		(proc5_9 440 36)
	)

	(method (buyClue &tmp temp0 temp1)
		(cond
			(local60
				(proc5_9 440 37)
			)
			((super buyClue: &rest)
				(if local59
					(= temp0 (localproc_0 0))
					(jobPuzzle select: temp0)
				else
					(= local59 (localproc_0 10))
					(local59 mask:)
					(= temp0 (localproc_0 0))
					(jobPuzzle select: temp0)
				)
			)
		)
	)
)

(instance choice_GAuswahl of CodeIcon
	(properties
		name {choice}
		view 450
		loop 10
		cel 0
		signal 133
		maskView 450
		maskCel 1
	)

	(method (show)
		(= view (proc0_3 451 450 450 450 450))
		(super show: &rest)
	)

	(method (select)
		(cond
			(local60 0)
			((not cel)
				(super select: &rest)
			)
			((not local59) 0)
			((== (local59 value:) value)
				(= [local50 value] 1)
				(jobPuzzle disable: local59)
				(gCMusic2 number: 58 setLoop: 1 play:)
				(self mask: cel: 0 show:)
				(++ local61)
				(= local59 0)
				(localproc_1)
				(if (>= local61 9)
					(gCMusic2 number: 50 setLoop: 1 play:)
					(= local62 1)
					(Wait 0)
					(Wait 45)
					(jobPuzzle goAway:)
				)
			)
			(else
				(if 1
					(= global408 (Memory memALLOC_CRIT (StrLen [local81 value])))
					(= global409 (Memory memALLOC_CRIT (StrLen [local81 value])))
					(StrSplitInTwo global408 global409 [local81 value])
					(proc5_14 440 38 global408 global409)
					(Memory memFREE global408)
					(Memory memFREE global409)
				)
				(localproc_1)
				(gCMusic2 number: 63 setLoop: 1 play:)
				(localproc_3 1)
			)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(= temp0 (- nsTop 1))
		(= temp1 (- nsLeft 1))
		(= temp2 nsBottom)
		(= temp3 nsRight)
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) (+ nsBottom 1) (+ nsRight 3) 1)
	)
)

(instance lastIcon of IconI
	(properties
		signal 128
	)

	(method (show))

	(method (highlight))

	(method (select))
)

(instance button_GKnopf of CodeIcon
	(properties
		name {button}
		view 450
		cel 1
		signal 128
		maskView 450
		maskCel 1
	)

	(method (show)
		(= view (proc0_3 451 450 450 450 450))
		(super show: &rest)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(cond
			((& signal $0004) 0)
			(local60
				(= temp1 (Random 0 8))
				(= temp2 (- 1 (* 2 (Random 0 1))))
				(= temp3 0)
				(while (<= temp3 8)
					(breakif (& ((= temp0 [local32 temp1]) signal:) $0004))
					(++ temp3)
					(if (> (+= temp1 temp2) 8)
						(= temp1 0)
					)
					(if (< temp1 0)
						(= temp1 8)
					)
				)
				(gCMusic2 number: 60 setLoop: 1 play:)
				(temp0
					loop: loop
					cel: cel
					value: value
					signal: (& ([local32 value] signal:) $fffb)
					show:
				)
				(lastIcon
					nsTop: nsTop
					nsLeft: nsLeft
					nsBottom: nsBottom
					nsRight: nsRight
				)
				(jobPuzzle disable: self)
				(if (>= (++ local61) 9)
					(localproc_2)
				else
					(self mask:)
				)
			)
			((== local59 self)
				(gCMusic2 number: 61 setLoop: 1 play:)
				(self show:)
				(localproc_1)
				(= local59 0)
			)
			(local59
				(gCMusic2 number: 58 setLoop: 1 play:)
				(local59 show:)
				(= local59 self)
				(proc5_13 [local72 value])
				(self mask:)
			)
			(else
				(gCMusic2 number: 59 setLoop: 1 play:)
				(= local59 self)
				(proc5_13 [local72 value])
				(self mask:)
			)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(= temp0 (- nsTop 1))
		(= temp1 (- nsLeft 1))
		(= temp2 nsBottom)
		(= temp3 nsRight)
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) (+ nsBottom 1) (+ nsRight 3) 1)
	)
)

(instance jobWindow of SysWindow
	(properties
		top 5
		left 60
		bottom 188
		right 269
		back 43
		priority 14
	)

	(method (open)
		(super open: &rest)
		(DrawCel (proc0_3 451 450 450 450 450) 0 0 0 local126 15)
	)
)

(instance bookPuzzle of PuzzleBar
	(properties
		puzzleHeight 116
		bottomHeight 30
		hintFlag 47
		solvedFlag 39
	)

	(method (init &tmp temp0 temp1)
		(= window (bookWindow back: [local0 2] yourself:))
		(= local127 0)
		(= local210 global114)
		(= local205 0)
		(= local206 0)
		(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			(= [local195 temp0]
				(switch global114
					(0 [local165 temp0])
					(1 [local175 temp0])
					(else [local185 temp0])
				)
			)
		)
		(= local209 22)
		(self add: (chicken init:))
		(for ((= temp0 0)) (< temp0 15) ((++ temp0))
			(cond
				((not (= temp1 [local279 temp0]))
					(= [local137 temp0] 0)
				)
				((< [local279 temp0] 5)
					(self
						add:
							((= [local130 (- temp1 1)] (realBook new:))
								nsTop: [local234 temp0]
								nsLeft: [local219 temp0]
								loop: temp1
								value: temp0
								yourself:
							)
					)
					(= [local137 temp0] 1)
				)
				(else
					(self
						add:
							((= [local134 (- temp1 5)] (dummyBook new:))
								nsTop: [local234 temp0]
								nsLeft: [local219 temp0]
								loop: temp1
								value: temp0
								yourself:
							)
					)
					(= [local137 temp0] 1)
				)
			)
		)
		(if (gEgo has: 18)
			(self
				add:
					((= [local130 0] (realBook new:))
						nsLeft: 2
						nsTop: 143
						loop: 1
						cel: 0
						value: 15
						yourself:
					)
			)
			(= [local152 0] 1)
		)
		(if (gEgo has: 19)
			(self add: (codePaper init:))
		)
		(bookCast add: (moveBook hide: yourself:))
		(= local214 84)
		(= local213 43)
		(super init: &rest)
	)

	(method (animateOnce)
		(if (& state $0020)
			(= gGameTime (+ gTickOffset (GetTime)))
			(if (self script:)
				(gTimers eachElementDo: #doit)
			)
			(wrongGuessTimer delete:)
			(if local127
				(= local207 (+ eventX 60))
				(= local208 (+ eventY 5))
				(moveBook x: local207 y: local208)
				(Animate (bookCast elements:) 1)
			)
			(if local216
				(gGame setCursor: gTheCursor 1 local213 local214)
				(= local216 0)
			)
			(return 0)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(if
			(and
				local127
				(not
					(and
						(< 0 eventX (- (window right:) (window left:)))
						(< 0 eventY (- (window bottom:) (window top:)))
					)
				)
			)
			(gGame setCursor: gTheCursor 1 local217 local218)
			(= eventX local217)
			(= eventY local218)
		)
		(= local217 eventX)
		(= local218 eventY)
		(= temp2 (event type:))
		(= temp3 (event message:))
		(cond
			((and local127 (or (== temp2 evMOUSEBUTTON) (== temp3 KEY_RETURN)))
				(= temp1 (event x:))
				(cond
					(
						(and
							(> (= temp0 (event y:)) 24)
							(> temp1 0)
							(< temp0 134)
							(< temp1 86)
						)
						(= temp5 (/ (- temp0 24) 22))
						(= temp7 0)
						(for
							((= temp6 (* temp5 3)))
							(and (not temp7) (< temp6 (* (+ temp5 1) 3)))
							((++ temp6))
							
							(if
								(and
									[local249 temp6]
									(> temp1 [local249 temp6])
									(< temp1 [local264 temp6])
								)
								(= temp7 temp6)
							)
						)
						(cond
							((not temp7)
								(gCMusic2 number: 58 setLoop: 1 play:)
								(proc5_9 440 39)
							)
							([local137 temp7]
								(gCMusic2 number: 58 setLoop: 1 play:)
								(proc5_9 440 39)
							)
							(else
								(gCMusic2 number: 61 setLoop: 1 play:)
								(localproc_1)
								(= [local137 temp7] 1)
								(moveBook hide:)
								(Animate (bookCast elements:) 1)
								(local129
									nsLeft: [local219 temp7]
									nsTop: [local234 temp7]
									loop: local279
									value: temp7
									cel: 0
									show:
								)
								(= local127 0)
								(if (== (local129 name:) {realBook})
									(cond
										(
											(==
												[local195 local205]
												(+
													(local129 loop:)
													(* (+ temp5 1) 10)
												)
											)
											(++ local205)
										)
										((bookPuzzle script:) 0)
										(else
											(bookPuzzle setScript: guessedWrong)
											(= local206 1)
										)
									)
								)
							)
						)
					)
					((and (> temp0 135) (> temp1 0) (< temp0 165) (< temp1 57))
						(gCMusic2 number: 60 setLoop: 1 play:)
						(localproc_1)
						(moveBook hide:)
						(Animate (bookCast elements:) 1)
						(for ((= temp6 0)) [local152 temp6] ((++ temp6))
						)
						(local129
							nsLeft: (+ 2 (* temp6 8))
							nsTop: 143
							loop: local279
							cel: 0
							value: (+ 15 temp6)
							show:
						)
						(= [local152 temp6] 1)
						(= local127 0)
					)
					((and (> temp0 139) (> temp1 58) (< temp0 165) (< temp1 86))
						(localproc_4)
					)
					(else
						(proc5_9 440 40)
					)
				)
				(event dispose:)
				(return 0)
			)
			((& temp2 $0040) ; direction
				(if (== local215 temp3)
					(cond
						((or (== local215 JOY_UP) (== local215 JOY_DOWN))
							(++ local212)
						)
						((or (== local215 JOY_LEFT) (== local215 JOY_RIGHT))
							(++ local211)
						)
					)
				else
					(= local211 3)
					(= local212 3)
				)
				(= local215 temp3)
				(switch temp3
					(JOY_UP
						(= temp9 (- local214 local212))
						(= temp8 local213)
					)
					(JOY_DOWN
						(= temp9 (+ local214 local212))
						(= temp8 local213)
					)
					(JOY_LEFT
						(= temp8 (- local213 local211))
						(= temp9 local214)
					)
					(JOY_RIGHT
						(= temp8 (+ local213 local211))
						(= temp9 local214)
					)
				)
				(cond
					((< temp8 0)
						(= temp8 0)
					)
					((> temp8 86)
						(= temp8 86)
					)
					((< temp9 0)
						(= temp9 0)
					)
					((> temp9 168)
						(= temp9 168)
					)
				)
				(= local213 temp8)
				(= local214 temp9)
				(gGame setCursor: gTheCursor 1 temp8 temp9)
				(event dispose:)
				(return 0)
			)
			(else
				(super dispatchEvent: event &rest)
			)
		)
	)

	(method (show)
		(phoneS fade:)
		(teletypeS fade:)
		(= local216 1)
		(= local215 0)
		(localproc_5)
		(= local206 0)
		(moveBook hide:)
		(super show: &rest)
		(localproc_1)
		(Animate (gCast elements:) 1)
		(if local164
			(self solvePuzzle:)
		)
		(phoneS vol: 127)
		(teletypeS vol: 127)
		(return local164)
	)

	(method (showHelp)
		(proc5_9 440 41)
		(proc5_9 440 42)
	)

	(method (buyClue)
		(cond
			((IsFlag 51)
				(proc5_9 440 43)
			)
			((super buyClue: &rest)
				(proc5_9 440 44)
				(bookPuzzle goAway:)
			)
		)
	)

	(method (hide)
		(bookCast eachElementDo: #hide)
		(if (IsObject wrongGuessTimer)
			(wrongGuessTimer dispose:)
		)
		(Animate (bookCast elements:) 0)
		(super hide: &rest)
	)

	(method (dispose)
		(bookCast eachElementDo: #dispose eachElementDo: #delete dispose:)
		(if (IsObject wrongGuessTimer)
			(wrongGuessTimer dispose:)
		)
		(super dispose: &rest)
	)
)

(instance bookCast of Set
	(properties)
)

(instance moveBook of Actor
	(properties
		view 445
		loop 1
		priority 15
		signal 16
	)
)

(instance bookWindow of SysWindow
	(properties
		top 5
		left 60
		bottom 173
		right 146
		back 43
		priority 14
	)

	(method (open)
		(super open: &rest)
		(DrawCel 445 0 0 0 local209 15)
	)
)

(instance dummyBook of CodeIcon
	(properties
		view 445
		cel 0
		signal 128
	)

	(method (select &tmp temp0)
		(gCMusic2 number: 62 setLoop: 1 play:)
		(= local127 1)
		(= local279 loop)
		(= local129 self)
		(if (< value 15)
			(= temp0 1)
			(= [local137 value] 0)
		else
			(= temp0 2)
			(= [local152 (- value 15)] 0)
		)
		(moveBook x: (+ nsLeft 63) y: (+ nsTop 13) loop: loop show:)
		(gGame setCursor: 50)
		(Animate (bookCast elements:) 1)
		(DrawCel view 0 temp0 nsLeft nsTop -1)
		(self cel: 2 show:)
	)

	(method (highlight param1)
		(if (not (== cel 2))
			(if param1
				(self cel: 1 show:)
			else
				(self cel: 0 show:)
			)
		)
	)
)

(instance realBook of CodeIcon
	(properties
		view 445
		cel 0
		signal 128
	)

	(method (select &tmp temp0)
		(gCMusic2 number: 62 setLoop: 1 play:)
		(cond
			((> value 14) 0)
			((== [local195 local205] loop)
				(++ local205)
			)
			((bookPuzzle script:) 0)
			(else
				(bookPuzzle setScript: guessedWrong)
				(= local206 1)
			)
		)
		(= local127 1)
		(= local279 loop)
		(= local129 self)
		(moveBook x: (+ nsLeft 63) y: (+ nsTop 13) loop: loop show:)
		(gGame setCursor: 50)
		(Animate (bookCast elements:) 1)
		(if (< value 15)
			(= temp0 1)
			(= [local137 value] 0)
		else
			(= temp0 2)
			(= [local152 (- value 15)] 0)
		)
		(DrawCel view 0 temp0 nsLeft nsTop -1)
		(self cel: 2 show:)
	)

	(method (highlight param1)
		(if (not (== cel 2))
			(if param1
				(self cel: 1 show:)
			else
				(self cel: 0 show:)
			)
		)
	)
)

(instance chicken of CodeIcon
	(properties
		view 445
		loop 8
		cel 2
		nsLeft 14
		nsTop 92
	)

	(method (select)
		(DrawCel view loop 3 nsLeft nsTop 15)
		(self cel: 1 show:)
		(gCMusic2 number: 957 setLoop: 1 play:)
		(Wait 0)
		(Wait 20)
		(if (== (bookPuzzle highlightedIcon:) self)
			(self highlight: 1)
		else
			(self highlight: 0)
		)
		(if (== [local195 local205] 69)
			(= local164 1)
			(bookPuzzle goAway:)
		else
			(proc5_9 440 45)
		)
	)

	(method (highlight param1)
		(if param1
			(DrawCel view loop 3 nsLeft nsTop 15)
			(self cel: 0 show:)
		else
			(DrawCel view loop 3 nsLeft nsTop 15)
			(self cel: 2 show:)
		)
	)
)

(instance codePaper of CodeIcon
	(properties
		view 445
		loop 9
		cel 0
		nsLeft 58
		nsTop 139
	)

	(method (select &tmp temp0)
		(localproc_4)
	)
)

(instance guessedWrong of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(wrongGuessTimer set60ths: self 1200)
			)
			(1
				(gCMusic2 number: 57 setLoop: 1 play:)
				(cond
					((< local205 2)
						(proc5_9 440 46)
					)
					((< local205 4)
						(proc5_9 440 47)
					)
					((< local205 6)
						(proc5_9 440 48)
					)
					(else
						(proc5_9 440 49)
					)
				)
				(localproc_5)
				(= local206 0)
				(bookPuzzle goAway:)
				(self dispose:)
			)
		)
	)
)

(instance wrongGuessTimer of Timer
	(properties)
)

(instance TTDBoard of Feature
	(properties
		nsTop 8
		nsLeft 242
		nsBottom 109
		nsRight 305
		description {Things To Do Now board}
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 50) ; "This board is labelled "Things to Do Now!"."
			)
			((== theVerb 3)
				(proc5_9 440 51)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance otherDeskDrawers of Feature
	(properties
		nsTop 145
		nsLeft 194
		nsBottom 187
		nsRight 216
		description {fake drawer}
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 3) (== theVerb 2))
			(proc5_9 440 52)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance blotter of Feature
	(properties
		nsTop 102
		nsLeft 183
		nsBottom 139
		nsRight 262
		description {desk blotter}
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 53) ; "The desk blotter is covered with esoteric scribblings. From them, you learn that E=mc squared, and that Dr. Brain's favorite food is a thick crust sausage and artichoke pizza."
			)
			((== theVerb 3)
				(proc5_9 440 54)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stapler of Feature
	(properties
		nsTop 95
		nsLeft 177
		nsBottom 106
		nsRight 205
		description {stapler}
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 55) ; "It's a desk stapler."
			)
			((== theVerb 3)
				(proc5_9 440 56)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance papersOnFloor of Feature
	(properties
		nsTop 153
		nsBottom 189
		nsRight 195
		description {loose papers}
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 57) ; "It appears that Dr. Brain could use a housekeeper as well as a lab assistant. Busy scientists go through a lot of paper."
			)
			((== theVerb 3)
				(proc5_9 440 58)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pictureWindow of Feature
	(properties
		nsTop 32
		nsBottom 94
		nsRight 41
		description {window}
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 59) ; "You admire the landscape beyond the window for a few moments. Then you remember that you're in the basement."
			)
			((== theVerb 3)
				(proc5_9 440 60)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mirror of Feature
	(properties
		nsTop 52
		nsLeft 99
		nsBottom 72
		nsRight 116
		description {mirror frame}
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 61) ; "It's a mirror frame, minus the mirror (a mere frame?)."
			)
			((== theVerb 3)
				(proc5_9 440 62)
				(proc5_9 440 63)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dart of Feature
	(properties
		nsTop 82
		nsLeft 250
		nsBottom 90
		nsRight 268
		description {dart}
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 440 64) ; "Dr. Brain uses a scientific system of pseudo-random determination to decide which job to tackle next. In other words, he throws darts."
			)
			((== theVerb 3)
				(proc5_9 440 65)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance phoneS of Sound
	(properties
		flags 1
		number 919
		loop -1
	)
)

(instance teletypeS of Sound
	(properties
		flags 1
		number 954
		loop -1
	)
)
