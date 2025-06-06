;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 994)
(include sci.sh)
(use Main)
(use Interface)
(use Polygon)
(use Sound)
(use Save)
(use Motion)
(use Inventory)
(use User)
(use System)

(procedure (PromptForDiskChange saveDisk &tmp ret [saveDevice 40] [curDevice 40] str [buf1 40] [buf2 10] [buf3 5])
	(= str (Memory memALLOC_CRIT (if 0 200 else 80)))
	(= ret 1)
	(DeviceInfo diGET_DEVICE gCurSaveDir @saveDevice)
	(DeviceInfo diGET_CURRENT_DEVICE @curDevice)
	(if
		(and
			(DeviceInfo diIS_FLOPPY @curDevice)
			(or
				(DeviceInfo diPATHS_EQUAL @saveDevice @curDevice)
				(not (DeviceInfo 6 (gGame name:))) ; SaveDirMounted
			)
		)
		(Message msgGET 0 1 0 1 27 @buf1) ; "Please insert your %s disk in drive %s."
		(Message msgGET 0 1 0 1 28 @buf2) ; "SAVE GAME"
		(Message msgGET 0 1 0 1 29 @buf3) ; "GAME"
		(Format str @buf1 (if saveDisk @buf2 else @buf3) @saveDevice)
		(Load rsFONT gUserFont)
		(DeviceInfo 4) ; CloseDevice
		(Message msgGET 0 1 0 1 12 @buf1) ; "Ok"
		(Message msgGET 0 1 0 1 13 @buf2) ; "Cancel"
		(Message msgGET 0 1 0 1 17 @buf3) ; "Change Directory"
		(if
			(==
				(= ret
					(if saveDisk
						(Print
							str
							#font
							0
							#button
							@buf1
							1
							#button
							@buf2
							0
							#button
							@buf3
							2
						)
					else
						(Print str #font 0 #button @buf1 1)
					)
				)
				2
			)
			(= ret (GetDirectory gCurSaveDir))
		)
	)
	(Memory memFREE str)
	(return ret)
)

(instance cast of EventHandler
	(properties)
)

(instance features of EventHandler
	(properties)
)

(instance theDoits of EventHandler
	(properties)
)

(instance sFeatures of EventHandler
	(properties)

	(method (delete theElement)
		(super delete: theElement)
		(if
			(and
				gUseSortedFeatures
				(theElement isKindOf: Collect)
				(not (OneOf theElement gRegions gLocales))
			)
			(theElement release: dispose:)
		)
	)
)

(class sounds of EventHandler
	(properties)

	(method (pause tOrF)
		(self eachElementDo: #perform mayPause (if argc tOrF else 1))
	)
)

(instance mayPause of Code
	(properties)

	(method (doit theSound tOrF)
		(if (not (& (theSound flags:) $0001))
			(theSound pause: tOrF)
		)
	)
)

(instance regions of EventHandler
	(properties)
)

(instance locales of EventHandler
	(properties)
)

(instance addToPics of EventHandler
	(properties)

	(method (doit)
		(self eachElementDo: #perform aTOC)
		(AddToPic elements)
	)
)

(instance controls of Controls
	(properties)
)

(instance timers of Set
	(properties)
)

(instance aTOC of Code
	(properties)

	(method (doit thePV &tmp dX dY)
		(if (not (| (thePV signal:) $4000))
			(= dX (+ (gEgo xStep:) (/ (CelWide (gEgo view:) 2 0) 2)))
			(= dY (* (gEgo yStep:) 2))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						init:
							(- (thePV brLeft:) dX)
							(- (CoordPri 1 (CoordPri (thePV y:))) dY)
							(+ (thePV brRight:) dX)
							(- (CoordPri 1 (CoordPri (thePV y:))) dY)
							(+ (thePV brRight:) dX)
							(+ (thePV y:) dY)
							(- (thePV brLeft:) dX)
							(+ (thePV y:) dY)
						yourself:
					)
			)
		)
	)
)

(class Game of Obj
	(properties
		script 0
		parseLang 1
		printLang 1
		subtitleLang 0
		_detailLevel 3
		egoMoveSpeed 0
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (GetSaveDir))
		(if (not (GameIsRestarting))
			(GetCWD gCurSaveDir)
		)
		(self setCursor: gWaitCursor 1 init: setCursor: gNormalCursor 1)
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (quitGame tOrF)
		(if (or (not argc) tOrF)
			(= gQuit 1)
		)
	)

	(method (masterVolume newVol)
		(if argc
			(DoSound sndMASTER_VOLUME newVol)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (detailLevel theLevel)
		(if argc
			(= _detailLevel theLevel)
			(gCast eachElementDo: #checkDetail)
		)
		(return _detailLevel)
	)

	(method (replay)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(gSFeatures release:)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gCast eachElementDo: #perform RU)
		(if (IsObject gFastCast)
			(gFastCast eachElementDo: #underBits 0)
		)
		(gGame setCursor: gWaitCursor 1)
		(DrawPic
			(gCurRoom curPic:)
			(if (== (gCurRoom style:) -1)
				100
			else
				(| $0064 (& (gCurRoom style:) $6000))
			)
			1
			global40
		)
		(if (!= gOverlays -1)
			(DrawPic gOverlays 100 0 global40)
		)
		(if (gCurRoom controls:)
			((gCurRoom controls:) draw:)
		)
		(if gAddToPics
			(gAddToPics doit:)
		)
		(gGame
			setCursor:
				(cond
					((and gTheIconBar (gTheIconBar curIcon:))
						((gTheIconBar curIcon:) cursor:)
					)
					((not (User canControl:)) gWaitCursor)
					(else gNormalCursor)
				)
		)
		(SL doit:)
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (init)
		Motion
		Sound
		(ScriptID 932)
		((= gCast cast) add:)
		((= gFeatures features) add:)
		((= gSFeatures sFeatures) add:)
		((= gSounds sounds) add:)
		((= gRegions regions) add:)
		((= gLocales locales) add:)
		((= gAddToPics addToPics) add:)
		((= gTimers timers) add:)
		((= gTheDoits theDoits) add:)
		(= gFastCast 0)
		(= gCurSaveDir (GetSaveDir))
		(Inv init:)
		(if (not gUser)
			(= gUser User)
		)
		(gUser init:)
	)

	(method (doit &tmp event evtTime)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if gFastCast
			(while gFastCast
				(gFastCast eachElementDo: #doit)
				(if (and ((= event (Event new:)) type:) gFastCast)
					(gFastCast firstTrue: #handleEvent event)
				)
				(event dispose:)
			)
		else
			(gSounds eachElementDo: #check)
			(gTimers eachElementDo: #doit)
			(if gModelessDialog
				(gModelessDialog check:)
			)
			(Animate (gCast elements:) 1)
			(if gFastCast
				(return)
			)
			(if gDoMotionCue
				(= gDoMotionCue 0)
				(gCast eachElementDo: #motionCue)
			)
			(if script
				(script doit:)
			)
			(gRegions eachElementDo: #doit)
			(if gFastCast
				(return)
			)
			(if (== gNewRoomNum gCurRoomNum)
				(gUser doit:)
			)
			(gTheDoits doit:)
			(if (!= gNewRoomNum gCurRoomNum)
				(self newRoom: gNewRoomNum)
			)
			(gTimers eachElementDo: #delete)
			(GameIsRestarting 0)
		)
	)

	(method (newRoom newRoomNumber &tmp [temp0 5] temp5)
		(gAddToPics eachElementDo: #dispose release:)
		(gFeatures eachElementDo: #perform fDC release:)
		(gCast eachElementDo: #dispose eachElementDo: #delete)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR release:)
		(gLocales eachElementDo: #dispose release:)
		(gTheDoits release:)
		(Animate 0)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(FlushResources newRoomNumber)
		(self startRoom: gCurRoomNum checkAni:)
		(Empty gRegions)
		(while ((= temp5 (Event new: evMOUSE)) type:)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)

	(method (checkAni &tmp theExtra)
		(Animate (gCast elements:) 0)
		(Wait 0)
		(Animate (gCast elements:) 0)
		(while (> (Wait 0) global30)
			(breakif (== (= theExtra (gCast firstTrue: #isExtra)) 0))
			(theExtra addToPic:)
			(Animate (gCast elements:) 0)
			(gCast eachElementDo: #delete)
		)
	)

	(method (startRoom roomNum)
		(if gDebugOn
			(SetDebug)
		)
		(gRegions addToFront: (= gCurRoom (ScriptID roomNum)))
		(gCurRoom init:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:) 1)
			((and script (script handleEvent: event)) 1)
			((== (event type:) evVERB)
				(self pragmaFail:)
			)
		)
		(event claimed:)
	)

	(method (changeScore delta)
		(+= gScore delta)
		(SL doit:)
	)

	(method (restart)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(RestartGame)
	)

	(method (save &tmp [temp0 20] temp20 temp21 temp22 [temp23 100] [temp123 5] [temp128 100])
		(if (not (ValidPath gCurSaveDir))
			(Message msgGET 0 1 0 1 15 @temp23) ; "%s is not a valid directory."
			(Format @temp128 @temp23 gCurSaveDir)
			(Print @temp128)
			(GetDirectory gCurSaveDir)
		)
		(= temp22 parseLang)
		(= parseLang 1)
		(Load rsFONT gSmallFont)
		(ScriptID 990)
		(Sound pause: 1)
		(if (PromptForDiskChange 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(= temp21 (self setCursor: gNormalCursor 1))
			(= temp20 (Save doit: @temp0))
			(self setCursor: temp21 1)
			(if (!= temp20 -1)
				(= parseLang temp22)
				(= temp21 (self setCursor: gWaitCursor 1))
				(if (not (SaveGame name temp20 @temp0 gVersion))
					(Message msgGET 0 1 0 0 1 24 @temp23) ; "The About button will give you info on other neat Sierra games."
					(Message msgGET 0 1 0 0 1 12 @temp123) ; "The About button will give you info on other neat Sierra games."
					(Print @temp23 #font 0 #button @temp123 1)
				)
				(self setCursor: temp21 1)
			)
			(PromptForDiskChange 0)
		)
		(Sound pause: 0)
		(= parseLang temp22)
	)

	(method (restore &tmp [temp0 20] temp20 temp21 temp22 [temp23 100] [temp123 5] [temp128 100])
		(if (not (ValidPath gCurSaveDir))
			(Message msgGET 0 1 0 1 15 @temp23) ; "%s is not a valid directory."
			(Format @temp128 @temp23 gCurSaveDir)
			(Print @temp128)
			(GetDirectory gCurSaveDir)
		)
		(= temp22 parseLang)
		(= parseLang 1)
		(Load rsFONT gSmallFont)
		(ScriptID 990)
		(= temp21 (self setCursor: gNormalCursor))
		(Sound pause: 1)
		(if (PromptForDiskChange 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(if (!= (= temp20 (Restore doit: &rest)) -1)
				(self setCursor: gWaitCursor 1)
				(if (CheckSaveGame name temp20 gVersion)
					(RestoreGame name temp20 gVersion)
				else
					(Message msgGET 0 1 0 1 25 @temp23) ; "That game was saved under a different interpreter. It cannot be restored."
					(Message msgGET 0 1 0 1 12 @temp123) ; "Ok"
					(Print @temp23 #font 0 #button @temp123 1)
					(self setCursor: temp21 1)
					(= parseLang temp22)
				)
			else
				(= parseLang temp22)
			)
			(PromptForDiskChange 0)
		)
		(Sound pause: 0)
	)

	(method (setSpeed newSpeed &tmp oldSpeed)
		(= oldSpeed gSpeed)
		(= gSpeed newSpeed)
		(return oldSpeed)
	)

	(method (setCursor form &tmp oldCur)
		(= oldCur gTheCursor)
		(= gTheCursor form)
		(if (IsObject form)
			(form init:)
		else
			(gNormalCursor init:)
		)
		(return oldCur)
	)

	(method (showMem &tmp [buffer 200])
		(Message msgGET 0 1 0 1 26 @buffer) ; "Free Heap: %u Bytes Largest ptr: %u Bytes FreeHunk: %u KBytes Largest Hunk: %u Bytes"
		(Printf
			@buffer
			(MemoryInfo 1) ; FreeHeap
			(MemoryInfo 0) ; LargestPtr
			(>> (MemoryInfo miFREEHUNK) $0006)
			(MemoryInfo miLARGESTHUNK)
		)
	)

	(method (pragmaFail))

	(method (notify))

	(method (setScript newScript)
		(if script
			(script dispose:)
		)
		(if newScript
			(newScript init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)
)

(instance talkerEvent of Event ; UNUSED
	(properties)
)

(class Rgn of Obj
	(properties
		script 0
		number 0
		timer 0
		keep 0
		initialized 0
		lookStr 0
	)

	(method (init)
		(if (not initialized)
			(= initialized 1)
			(if (not (gRegions contains: self))
				(gRegions addToEnd: self)
			)
			(super init:)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:) 1)
			(
				(not
					(and
						script
						(or (script handleEvent: event) 1)
						(event claimed:)
					)
				)
				(event
					claimed:
						(self
							doVerb:
								(event message:)
								(and
									gInventory
									gTheIconBar
									(== (event message:) JOY_DOWNRIGHT)
									(gInventory indexOf: (gTheIconBar curInvIcon:))
								)
						)
				)
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 2) lookStr) ; Look
			(Printf 994 0 lookStr) ; "%s"
			(return 1)
		else
			(return 0)
		)
	)

	(method (dispose)
		(gRegions delete: self)
		(if (IsObject script)
			(script dispose:)
		)
		(if (IsObject timer)
			(timer dispose:)
		)
		(gSounds eachElementDo: #clean self)
		(DisposeScript number)
	)

	(method (setScript newScript)
		(if (IsObject script)
			(script dispose:)
		)
		(if newScript
			(newScript init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)

	(method (newRoom))

	(method (notify))
)

(class Rm of Rgn
	(properties
		picture 0
		style -1
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY -30000
		obstacles 0
	)

	(method (init &tmp how)
		(= number gCurRoomNum)
		(= controls controls)
		(= gPerspective picAngle)
		(if picture
			(self drawPic: picture)
		)
		(self reflectPosn: (gUser alterEgo:) ((gUser alterEgo:) edgeHit:))
		((gUser alterEgo:) edgeHit: EDGE_NONE)
	)

	(method (reflectPosn theActor theEdge)
		(switch theEdge
			(1
				(theActor y: 188)
			)
			(4
				(theActor x: (- 319 (theActor xStep:)))
			)
			(3
				(theActor y: (+ horizon (theActor yStep:)))
			)
			(2
				(theActor x: 1)
			)
		)
	)

	(method (doit &tmp nRoom)
		(if script
			(script doit:)
		)
		(if (= nRoom (self edgeToRoom: ((gUser alterEgo:) edgeHit:)))
			(self newRoom: nRoom)
		)
	)

	(method (edgeToRoom edge)
		(return
			(switch edge
				(1 north)
				(2 east)
				(3 south)
				(4 west)
			)
		)
	)

	(method (roomToEdge rm)
		(return
			(switch rm
				(north 1)
				(south 3)
				(east 2)
				(west 4)
			)
		)
	)

	(method (dispose)
		(if controls
			(controls dispose:)
		)
		(if obstacles
			(obstacles dispose:)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(or
			(super handleEvent: event)
			(and controls (controls handleEvent: event))
		)
		(event claimed:)
	)

	(method (setRegions region &tmp i n regID)
		(for ((= i 0)) (< i argc) ((++ i))
			(= n [region i])
			(= regID (ScriptID n))
			(regID number: n)
			(gRegions add: regID)
			(if (not (regID initialized:))
				(regID init:)
			)
		)
	)

	(method (setLocales locale &tmp i n locID)
		(for ((= i 0)) (< i argc) ((++ i))
			(= n [locale i])
			((= locID (ScriptID n)) number: n)
			(gLocales add: locID)
			(locID init:)
		)
	)

	(method (setFeatures feature &tmp temp0 [temp1 2])
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(gFeatures add: [feature temp0])
		)
	)

	(method (addObstacle obstacle)
		(if (not (IsObject obstacles))
			(= obstacles (List new:))
		)
		(obstacles add: obstacle &rest)
	)

	(method (newRoom newRoomNumber)
		(gRegions delete: self eachElementDo: #newRoom newRoomNumber addToFront: self)
		(= gNewRoomNum newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (drawPic pic theStyle)
		(if gAddToPics
			(gAddToPics eachElementDo: #dispose release:)
		)
		(if (and (>= argc 2) (& theStyle $4000))
			(|= style $4000)
		)
		(= curPic pic)
		(= gOverlays -1)
		(DrawPic
			pic
			(cond
				((== argc 2) theStyle)
				((!= style -1) style)
				(else global17)
			)
			1
			global40
		)
	)

	(method (overlay pic theStyle)
		(= gOverlays pic)
		(DrawPic
			pic
			(cond
				((== argc 2) theStyle)
				((!= style -1) style)
				(else global17)
			)
			0
			global40
		)
	)
)

(class Locale of Obj
	(properties
		number 0
	)

	(method (handleEvent event)
		(event claimed:)
	)

	(method (dispose)
		(gLocales delete: self)
		(DisposeScript number)
	)
)

(class SL of Obj
	(properties
		state 0
		code 0
	)

	(method (doit &tmp theLine)
		(if code
			(= theLine (Memory memALLOC_CRIT (if 0 240 else 82)))
			(code doit: theLine)
			(DrawStatus (if state theLine else 0))
			(Memory memFREE theLine)
		)
	)

	(method (enable)
		(= state 1)
		(self doit:)
	)

	(method (disable)
		(= state 0)
		(self doit:)
	)
)

(instance RU of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (param1 underBits:)
			(= temp0 (& (= temp0 (| (= temp0 (param1 signal:)) $0001)) $fffb))
			(param1 underBits: 0 signal: temp0)
		)
	)
)

(instance DNKR of Code
	(properties)

	(method (doit param1)
		(if (not (param1 keep:))
			(param1 dispose:)
		)
	)
)

(instance fDC of Code
	(properties)

	(method (doit theFeature)
		(if (theFeature respondsTo: #delete)
			(theFeature signal: (& (theFeature signal:) $ffdf) dispose: delete:)
		else
			(theFeature dispose:)
		)
	)
)

