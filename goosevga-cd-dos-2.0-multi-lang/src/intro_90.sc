;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use n098)
(use Interface)
(use SysWindow)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	intro 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 52
	local5 = 107
	[local6 48] = [23 55 66 99 69 55 111 99 114 55 156 99 159 55 201 99 204 55 245 99 249 55 292 99 23 105 66 143 69 105 111 143 114 105 156 143 159 105 201 143 204 105 245 143 249 105 292 143]
	[local54 48] = [23 55 66 99 69 55 111 99 114 55 156 99 159 55 201 99 204 55 245 99 249 55 292 99 23 105 66 143 69 105 111 143 114 105 156 143 159 105 201 143 204 105 245 143 249 105 292 143]
	[local102 48]
	[local150 250]
	[local400 12]
	local412
	local413
	local414
	[local415 132]
	[local547 73] = [0 0 0 0 0 0 0 0 0 0 0 0 0 {ALAN} {_____ANDY} {_____ANTHONY} {__BRIAN} {____BRETT} {____CHRIS} {____DAVID} {____DILLON} {___EDWARD} {___ERIC} {_____FRANK} {____GARY} {_____GREGORY} {__JAMES} {____JOHN} {_____JOSHUA} {___KEN} {______KEVIN} {____LARRY} {____MARK} {_____MICHAEL} {__NEIL} {_____RICHARD} {__ROBERT} {___SCOTT} {____NATHANIEL} {STEVEN} {___THEODORE} { THOMAS} {___WILLIAM} {__AMY} {______ANN} {______BARBARA} {__BONNIE} {___CARRIE} {___CATHY} {____CINDY} {____DEBBIE} {___ELIZABETH} {GINNY} {____HANNAH} {___JANET} {____JENNIFER} { JESSICA} {__KAREN} {____KIM} {______LAURA} {____LISA} {_____MARIE} {____MARY} {_____MOLLY} {____NANCY} {____PATRICIA} { PENNY} {____ROBIN} {____STEPHANIE} {SUSAN} {____VANESSA} {__WENDY} {____YOLANDA}]
)

(procedure (localproc_0 param1 param2)
	(Box posn: param1 param2)
)

(procedure (localproc_1 param1 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 100) ((+= temp0 param1))
		(Palette palSET_INTENSITY 0 255 temp0)
		(Wait 2)
	)
	(Palette palSET_INTENSITY 0 255 100)
)

(procedure (localproc_2 param1 &tmp temp0)
	(for ((= temp0 100)) (>= temp0 0) ((-= temp0 param1))
		(Palette palSET_INTENSITY 0 255 temp0)
		(Wait 2)
	)
	(Palette palSET_INTENSITY 0 255 0)
)

(procedure (localproc_3 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(if (> argc 2)
		(= temp2 param3)
		(= temp3 param4)
	else
		(= temp2 4)
		(= temp3 3)
	)
	(Load rsPIC param1)
	(if (gCurRoom picture:)
		(localproc_2 temp3)
	)
	(gCurRoom picture: param1 drawPic: param1)
	(Animate (gCast elements:) 0)
	(localproc_1 temp2)
	(for ((= temp0 0)) (< temp0 param2) ((++ temp0))
		(Wait 1)
		(= temp1 (Event new:))
		(if (== (temp1 message:) KEY_F2)
			(if local414
				(= local414 0)
				(DoSound sndSET_SOUND 1)
			else
				(= local414 1)
				(DoSound sndSET_SOUND 0)
			)
		)
		(if (and (temp1 type:) (!= (temp1 message:) KEY_F2))
			(= param2 0)
			(= local3 630)
		)
		(temp1 dispose:)
	)
)

(procedure (localproc_4 param1 param2 param3 &tmp temp0 temp1) ; UNUSED
	(if global153
		(Display 90 0 dsRESTOREPIXELS global154)
		(Display 90 0 dsRESTOREPIXELS global153)
		(= global153 0)
	)
	(if (and global118 param1)
		(= temp0 (if (and (> argc 1) (>= param2 0)) param2 else 5))
		(= temp1 (if (and (> argc 2) (>= param3 0)) param3 else 5))
		(= global153
			(Display param1 dsWIDTH 240 dsCOORD temp0 temp1 dsALIGN alCENTER dsFONT 9 dsCOLOR 0 dsSAVEPIXELS)
		)
		(= global154
			(Display param1 dsWIDTH 240 dsCOORD temp0 temp1 dsALIGN alCENTER dsFONT 8 dsCOLOR 7 dsSAVEPIXELS)
		)
	)
)

(procedure (localproc_5)
	(for
		((= gSaveSlot 0))
		(and (< gSaveSlot local413) (!= (StrAt @local150 (* gSaveSlot 36)) 126))
		((++ gSaveSlot))
	)
	(if (< gSaveSlot local413)
		(= gSaveSlot [local400 gSaveSlot])
	else
		(++ gSaveSlot)
	)
	(return gSaveSlot)
)

(instance intro of Rm
	(properties
		style 0
	)

	(method (init)
		(= global176 1)
		(SetPort 0 0 190 320 0 0)
		(= local1 global62)
		(= global62 320)
		(super init:)
		(TheMenuBar state: 0)
		(SetCursor 69 1)
		(= global107 1)
		(= global114 0)
		(self setScript: introScript)
	)

	(method (dispose)
		(Animate (gCast elements:) 0)
		(= global107 0)
		(= global62 local1)
		(super dispose:)
	)
)

(instance introScript of Script
	(properties)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(switch (event type:)
			(evMOUSERELEASE
				(if (!= state 7)
					(switch state
						(10
							(for ((= temp0 0)) (< temp0 48) ((++ temp0))
								(= [local102 temp0] [local54 temp0])
							)
							(= temp2 local2)
						)
						(4
							(for ((= temp0 0)) (< temp0 48) ((++ temp0))
								(= [local102 temp0] [local6 temp0])
							)
							(= temp2 12)
						)
						(else
							(return)
						)
					)
					(for ((= temp0 0)) (<= temp0 temp2) ((++ temp0))
						(= temp1 (* temp0 4))
						(if
							(and
								(> (event x:) [local102 temp1])
								(< (event x:) [local102 (+ temp1 2)])
								(> (event y:) [local102 (+ temp1 1)])
								(< (event y:) [local102 (+ temp1 3)])
							)
							(= global114 temp0)
							(= cycles 1)
							(break)
						)
					)
					(event claimed: 1)
				)
			)
			($0040 ; direction
				(if (not (HaveMouse))
					(switch state
						(10
							(= temp0 global114)
							(switch (event message:)
								(JOY_DOWN
									(if (< global114 8)
										(+= global114 4)
									)
								)
								(JOY_UP
									(if (> global114 3)
										(-= global114 4)
									)
								)
								(JOY_RIGHT
									(if
										(and
											(!= global114 3)
											(!= global114 7)
											(!= global114 11)
										)
										(+= global114 1)
									)
								)
								(JOY_LEFT
									(if
										(and
											(!= global114 0)
											(!= global114 4)
											(!= global114 8)
										)
										(-= global114 1)
									)
								)
							)
							(if (> global114 local413)
								(= global114 temp0)
							)
							(= local413
								(GetSaveFiles (gGame name:) @local150 @local400)
							)
							(= temp3 (ReadNumber @[local150 (* temp0 18)]))
							(= temp1 1)
							(if (> temp3 9)
								(++ temp1)
							)
							(if (== temp0 local413)
								(= global180 {New Player})
								(= temp3 10)
							else
								(= global180 (+ @[local150 (* temp0 18)] temp1))
								(= temp3 (StrLen global180))
							)
							(Display
								global180
								dsWIDTH
								80
								dsCOORD
								(+ 22 (* 66 (mod temp0 4)))
								(+ 65 (* 45 (/ temp0 4)))
								dsALIGN
								alCENTER
								dsFONT
								6
								dsCOLOR
								0
							)
							(= temp3 (ReadNumber @[local150 (* global114 18)]))
							(= temp1 1)
							(if (> temp3 9)
								(++ temp1)
							)
							(if (== global114 local413)
								(= global180 {New Player})
							else
								(= global180
									(+ @[local150 (* global114 18)] temp1)
								)
							)
							(= temp3 (StrLen global180))
							(Display
								global180
								dsWIDTH
								80
								dsCOORD
								(+ 22 (* 66 (mod global114 4)))
								(+ 65 (* 45 (/ global114 4)))
								dsALIGN
								alCENTER
								dsFONT
								6
								dsCOLOR
								7
							)
							(gEgo
								x: (+ [local54 (* global114 4)] 7)
								y: (+ [local54 (+ (* global114 4) 1)] 30)
							)
						)
						(else
							(switch (event message:)
								(JOY_DOWN
									(if (!= local5 114)
										(+= global114 6)
									)
									(localproc_0 local4 (= local5 158))
								)
								(JOY_UP
									(if (!= local5 63)
										(-= global114 6)
									)
									(localproc_0 local4 (= local5 107))
								)
								(JOY_RIGHT
									(if (< local4 242)
										(localproc_0 (+= local4 40) local5)
										(+= global114 1)
									)
								)
								(JOY_LEFT
									(if (> local4 55)
										(localproc_0 (-= local4 40) local5)
										(-= global114 1)
									)
								)
							)
							(gEgo
								x: (+ [local6 (* global114 4)] 7)
								y: (+ [local6 (+ (* global114 4) 1)] 30)
							)
						)
					)
				else
					(event claimed: 1)
				)
			)
			(evKEYBOARD
				(switch (event message:)
					(KEY_F2
						(if local414
							(= local414 0)
							(DoSound sndSET_SOUND 1)
						else
							(= local414 1)
							(DoSound sndSET_SOUND 0)
						)
					)
				)
			)
		)
		(if (and local2 (== (event message:) KEY_RETURN))
			(event claimed: 1)
			(= cycles 1)
		)
	)

	(method (changeState newState &tmp temp0 [temp1 64] temp65)
		(switch (= state newState)
			(0
				(if (== global113 100)
					(if (= local412 (StrAt gCurSaveDir 0))
						(if (and (!= temp65 97) (!= temp65 65)) ; UNINIT, UNINIT
							(StrAt gCurSaveDir 2 0)
						)
						(= local413
							(GetSaveFiles (gGame name:) @local150 @local400)
						)
						(= register 0)
						(if local412
							(for
								((= temp65 0))
								(< temp65 local413)
								((++ temp65))
								
								(if (!= (StrAt @local150 (* temp65 36)) 126)
									(++ register)
								)
							)
						)
						(if register
							(= state 8)
						else
							(= global113 200)
						)
					else
						(SetPort 0 0 200 320 0 0)
						(Graph grFILL_BOX 190 0 200 320 1 0 0 0)
						(Graph grUPDATE_BOX 190 0 200 320 1)
						(SetPort 0 0 190 320 0 0)
						(gCurRoom picture: 0)
						(= global113 200)
					)
				else
					(StrCpy @temp1 {a:})
					(if (= local412 (DeviceInfo 5)) ; SaveDevice
						(StrAt @temp1 0 local412)
					else
						(= local412 (StrAt @temp1 0))
					)
					(if (ValidPath @temp1)
						(StrAt gCurSaveDir 0 local412)
						(= local413
							(GetSaveFiles (gGame name:) @local150 @local400)
						)
					else
						(DeviceInfo diGET_CURRENT_DEVICE @temp1)
						(ValidPath @temp1)
						(StrAt gCurSaveDir 0 (= local412 0))
						(= local413 0)
					)
					(SetPort 0 0 200 320 0 0)
					(localproc_3 501 150)
				)
				(= cycles 1)
			)
			(1
				(if (!= global113 200)
					(gGame setCursor: 901 1)
					(= register 0)
					(if local412
						(for ((= temp65 0)) (< temp65 local413) ((++ temp65))
							(if (!= (StrAt @local150 (* temp65 36)) 126)
								(++ register)
							)
						)
					)
					(proc0_12 0)
					(= temp65 global169)
					(proc0_12 1)
					(= temp1 (== global169 temp65))
					(= global169 temp65)
					(while 1
						(= temp65 (proc0_12 0))
						(if (and local412 register)
							(= temp0
								(if temp1
									(choices init: 181 0 28 1 1 121 2 2 215 3)
								else
									(choices
										init:
											181
											0
											10
											1
											1
											85
											2
											2
											160
											3
											(+ 3 temp65)
											235
											4
									)
								)
							)
							(if (and (>= register 12) (== temp0 2))
								(StrAt gCurSaveDir 0 (= local412 0))
								(Print 90 1) ; "The save disk is full. This game will not be saved."
							)
						else
							(= temp0
								(if temp1
									(choices init: 181 0 80 1 1 165 2)
								else
									(choices
										init:
											181
											0
											28
											1
											1
											121
											2
											(+ 3 temp65)
											215
											4
									)
								)
							)
						)
						(if (== temp0 4)
							(= global169 [global250 (+ temp65 1)])
						else
							(break)
						)
					)
					(if (!= temp0 3)
						(localproc_2 8)
						(Graph grFILL_BOX 190 0 200 320 1 0 0 0)
						(Graph grUPDATE_BOX 190 0 200 320 1)
						(gCurRoom picture: 0)
					)
					(SetPort 0 0 190 320 0 0)
				else
					(= temp0 2)
				)
				(switch temp0
					(1
						(= cycles 1)
						(= local3 601)
						(gGame setCursor: 69)
					)
					(2
						(gLongSong fade:)
						(for ((= local2 0)) (< local2 12) ((++ local2))
							((View new:)
								view: 200
								loop: 1
								cel: local2
								posn:
									(+ 45 (* 45 (mod local2 6)))
									(if (< local2 6) 90 else 133)
								init:
							)
						)
						(if (!= (gCurRoom picture:) 512)
							(localproc_3 512 0 8 6)
						)
						(+= state 2)
						(= cycles 1)
					)
					(3
						(if (and local412 (> local413 0))
							(gLongSong fade:)
							(= state 8)
							(= cycles 1)
						else
							(Print 90 2) ; "There are no save games on this disk."
							(= state 0)
							(= cycles 1)
						)
					)
					(else
						(StrAt gCurSaveDir 0 (= local412 0))
						(StrAt @global190 2 1)
						(StrAt @global190 3 (+ (localproc_5) 32))
						(StrAt @global190 4 37)
						(StrAt @global190 5 32)
						(MemorySegment 0 @global190 0) ; MS_SAVE_FROM
						(proc98_1)
						(DisposeScript 98)
					)
				)
			)
			(2
				(-- state)
				(if (< local3 616)
					(localproc_3 local3 200)
				else
					(SetPort 0 0 200 320 0 0)
					(localproc_3 501 0)
					(= state 0)
				)
				(++ local3)
				(= cycles 1)
			)
			(4
				(DoAudio audPLAY 498)
				(= seconds 15)
			)
			(5
				(if seconds
					(= seconds 0)
				else
					(self changeState: 4)
					(return)
				)
				(proc0_16 0)
				(StrAt @global190 4 (+ 32 (getName init:)))
				(= cycles 1)
			)
			(6
				(StrAt @global190 2 (+ 1 local412))
				(StrAt @global190 3 (+ (localproc_5) 32))
				(StrAt @global190 5 (+ global114 32))
				(MemorySegment 0 @global190 0) ; MS_SAVE_FROM
				(gCast eachElementDo: #dispose)
				(gLongSong fade:)
				(localproc_2 8)
				(Animate (gCast elements:) 0)
				(gGame restart:)
			)
			(9
				(if (gCurRoom picture:)
					(localproc_2 8)
				)
				(SetPort 0 0 200 320 0 0)
				(Graph grFILL_BOX 190 0 200 320 1 0 0 0)
				(Graph grUPDATE_BOX 190 0 200 320 1)
				(SetPort 0 0 190 320 0 0)
				(gCurRoom picture: 512 drawPic: 512)
				(= global109 (Graph grSAVE_BOX 93 24 102 294 1))
				(= global110 (Graph grSAVE_BOX 137 24 146 294 1))
				(= local2 (= temp65 0))
				(while (< temp65 local413)
					(= temp0 @[local150 (* temp65 18)])
					(if (!= (StrAt temp0 0) 126)
						((View new:)
							view: 200
							loop: 1
							cel: (- (StrAt temp0 1) 32)
							posn:
								(+ 45 (* 45 (mod local2 6)))
								(+ 90 (* 43 (/ local2 6)))
							init:
						)
						(= [local547 local2] temp65)
						(++ local2)
					)
					(++ temp65)
				)
				(-- local2)
				(Animate (gCast elements:) 0)
				(localproc_1 8)
				(gGame setCursor: 901 1)
				(= cycles 1)
			)
			(10
				(DoAudio audPLAY 503)
				(if (not (HaveMouse))
					(SetCursor 901 1)
				)
				(= seconds 15)
			)
			(11
				(if seconds
					(= seconds 0)
				else
					(self changeState: 10)
					(return)
				)
				(= gSaveSlot [local400 (= global114 [local547 global114])])
				(if (CheckSaveGame (gGame name:) gSaveSlot gVersion)
					(StrAt @global190 2 (+ 1 local412))
					(StrAt @global190 3 (+ gSaveSlot 32))
					(StrAt @global190 4 (StrAt @local150 (* global114 36)))
					(StrAt @global190 5 (StrAt @local150 (+ (* global114 36) 1)))
					(MemorySegment 0 @global190 0) ; MS_SAVE_FROM
					(SetPort 0 0 200 320 0 0)
					(Palette palSET_INTENSITY 0 255 0)
					(Graph grRESTORE_BOX global109)
					(Graph grRESTORE_BOX global110)
					(DrawPic 800 0)
					(Graph grFILL_BOX 3 4 159 262 1 0 0 0)
					(Graph grUPDATE_BOX 0 0 200 320 1)
					(gGame changeScore: 0)
					(gGame restore:)
				else
					(Print 90 3 #font 0 #button {OK} 1) ; "That game was saved under a different interpreter. It cannot be restored."
					(= state -1)
					(= global113 100)
					(= cycles 1)
				)
			)
		)
	)
)

(instance Box of Prop
	(properties
		y 105
		x 42
		view 200
	)
)

(instance getName of Dialog
	(properties)

	(method (init &tmp [temp0 2] temp2 temp3)
		(= temp3 (+ (= temp2 (* (mod global114 2) 30)) 30))
		(while (and (< temp2 temp3) [local415 temp2])
			(++ temp2)
		)
		(return temp2)
	)
)

(instance DPButton of DIcon
	(properties
		state 3
	)

	(method (track param1 &tmp temp0)
		(repeat
			(= param1 (Event new: evPEEK))
			(param1 localize:)
			(if (and (= temp0 (self check: param1)) (not cel))
				(++ cel)
				(self draw:)
			)
			(if (and (not temp0) cel)
				(-- cel)
				(self draw:)
			)
			(param1 dispose:)
			(breakif (not (StillDown)))
		)
		(= temp0 (if cel self else 0))
		(= cel 0)
		(self draw:)
		(return temp0)
	)
)

(instance choices of Controls
	(properties)

	(method (init param1 &tmp temp0 temp1 temp2)
		(= window SysWindow)
		(for ((= temp0 1)) (< temp0 argc) ((+= temp0 3))
			(self add: (= temp1 (DPButton new:)))
			(temp1
				view: [param1 0]
				loop: [param1 temp0]
				setSize:
				value: [param1 (+ 2 temp0)]
				moveTo: [param1 (+ 1 temp0)] 175
			)
		)
		(super init:)
		(self draw:)
		(= temp0 0)
		(while (not temp0)
			((= temp2 (Event new:)) localize:)
			(= temp0 (self handleEvent: temp2))
			(temp2 dispose:)
		)
		(= temp1
			(if (== temp0 27)
				temp0
			else
				(temp0 value:)
			)
		)
		(self dispose:)
		(return temp1)
	)
)

