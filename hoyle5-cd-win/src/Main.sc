;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 0)
(include sci.sh)
(use KeyMouse)
(use InvisibleWindow)
(use Piles)
(use h5Messager)
(use DItem)
(use Plane)
(use Str)
(use Print)
(use IconBar)
(use GameControls)
(use Ego)
(use Sound)
(use Motion)
(use File)
(use Game)
(use User)
(use Actor)
(use System)

(public
	hoyle4 0
	RedrawCast 1
	proc0_2 2
	EnableCursor 3
	DisableCursor 4
	proc0_5 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	proc0_9 9
	proc0_10 10
	proc0_11 11
	proc0_12 12
	cueableScript 13
	proc0_14 14
	proc0_15 15
)

(local
	; 0
	gEgo
	gGame
	gCurRoom
	gThePlane
	gQuit
	; 5
	gCast
	gRegions
	gTimers
	gSounds
	gInventory
	; 10
	gPlanes
	gCurRoomNum
	gPrevRoomNum
	gNewRoomNum
	gDebugOn
	; 15
	gScore
	gPossibleScore
	gTextCode
	gCuees
	gTheCursor
	; 20
	gNormalCursor
	gWaitCursor
	gUserFont = 1
	gSmallFont = 4
	gLastEvent
	; 25
	gEventMask = 32767
	gBigFont = 1
	gVersion
	gAutoRobot
	gCurSaveDir
	; 30
	gNumCD
	gPerspective
	gFeatures
	gPanels
	gUseSortedFeatures
	; 35
	global35
	gOverlays = -1
	gDoMotionCue
	gSystemPlane
	gSaveFileSelText
	; 40
	global40
	global41
	gSysLogPath
	global43
	global44
	; 45
	global45
	global46
	global47
	global48
	global49
	; 50
	global50
	global51
	global52
	global53
	global54
	; 55
	global55
	global56
	global57
	global58
	global59
	; 60
	global60
	global61
	gEndSysLogPath
	gGameControls
	gFtrInitializer
	; 65
	gDoVerbCode
	gApproachCode
	gUseObstacles = 1
	global68
	gTheIconBar
	; 70
	gMouseX
	gMouseY
	gKeyDownHandler
	gMouseDownHandler
	gDirectionHandler
	; 75
	gSpeechHandler
	gLastVolume
	gPMouse
	gTheDoits
	gEatMice = 60
	; 80
	gUser
	gSyncBias
	gTheSync
	gExtMouseHandler
	gTalkers
	; 85
	gInputFont
	gTickOffset
	gHowFast
	gGameTime
	gNarrator
	; 90
	gMsgType = 1
	gMessager
	gPrints
	gWalkHandler
	gTextSpeed = 2
	; 95
	gAltPolyList
	gScreenWidth = 320
	gScreenHeight = 200
	gLastScreenX = 319
	gLastScreenY = 199
	; 100
	global100
	global101 = 1234
	gAbsoluteCast
	gDelayCast
	gChar1
	; 105
	gChar2
	gChar3
	global107
	global108
	global109
	; 110
	gMouseCursor
	global111
	global112
	global113
	global114
	; 115
	global115
	global116
	global117
	gTheKeyMouseList
	global119
	; 120
	gGame_opt
	global121
	global122 = 1
	global123
	global124
	; 125
	global125
	global126
	global127
	global128
	global129
	; 130
	global130
	global131
	global132
	global133
	global134
	; 135
	global135
	global136
	global137
	global138
	global139
	; 140
	global140
	global141
	global142
	global143
	global144
	; 145
	global145
	global146
	global147
	global148
	global149
	; 150
	global150
	global151
	global152
	global153
	global154
	; 155
	global155
	global156
	global157
	global158
	global159
	; 160
	global160
	global161
	global162
	global163
	global164
	; 165
	global165
	global166
	global167
	global168
	global169
	; 170
	global170
	global171
	global172
	global173
	global174
	; 175
	global175
	global176
	global177
	global178
	global179
	; 180
	global180
	global181
	global182
	global183
	global184
	; 185
	global185
	global186
	global187
	global188
	global189
	; 190
	global190
	global191
	global192
	gCardGameScriptNumber
	gPlayerCount = 1
	; 195
	global195
	gSkill
	global197
	global198
	global199
	; 200
	global200
	global201
	global202
	global203
	global204
	; 205
	global205
	global206
	global207
	global208
	global209
	; 210
	global210
	global211
	global212
	global213
	global214
	; 215
	global215
	global216
	global217
	global218
	global219
	; 220
	gCrazy8s_opt
	global221
	global222
	global223
	global224
	; 225
	gOldmaid_opt
	global226
	global227
	global228
	global229
	; 230
	gHearts_opt
	global231
	global232
	global233
	global234
	; 235
	global235
	global236
	global237
	global238
	global239
	; 240
	gGinrummy_opt
	gGinRummyOptionSortMode
	gGinRummyOptionIsVariant
	gGinRummyTurnCount
	global244
	; 245
	global245
	global246
	global247
	global248
	global249
	; 250
	gCribbage_opt
	global251
	global252
	global253
	global254
	; 255
	global255 = 257
	global256
	global257
	global258
	global259
	; 260
	gKlondike_opt
	global261
	global262
	global263
	global264
	; 265
	global265
	global266
	global267
	global268
	global269
	; 270
	gBridge_opt
	global271
	global272
	global273
	global274
	; 275
	global275
	global276
	global277
	global278
	global279
	; 280
	global280
	global281
	global282
	global283
	global284
	; 285
	global285
	global286
	global287
	global288
	global289
	; 290
	global290
	global291
	global292
	global293
	global294
	; 295
	global295
	global296
	gSong
	gSound
	gSound2
	; 300
	global300
	global301
	global302
	global303
	global304
	; 305
	global305
	global306
	global307 = 1
	global308
	global309
	; 310
	global310
	global311
	global312 = 1
	global313
	global314
	; 315
	global315
	global316
	global317
	global318 = 30
	global319 = 40
	; 320
	global320 = 98
	global321 = 97
	global322 = 80
	global323 = 70
	global324 = 90
	; 325
	global325 = 20
	global326 = 60
	global327 = 95
	global328 = 99
	global329
	; 330
	global330
	global331
	global332
	global333
	global334
	; 335
	global335
	global336
	global337
	global338
	global339
	; 340
	global340
	global341
	global342
	global343 = 1
	global344
	; 345
	global345
	global346
	global347
	global348
	global349
	; 350
	global350
	global351
	global352
	global353
	global354
	; 355
	global355
	global356
	global357
	global358
	global359
	; 360
	global360
	global361
	global362
	global363
	global364
	; 365
	global365
	global366
	global367
	global368
	global369
	; 370
	global370
	global371
	global372
	global373
	global374
	; 375
	global375
	global376
	global377
	global378
	global379
	; 380
	global380
	global381
	global382
	gGcWindow
	global384
	; 385
	global385
	global386 = 10
	global387 = 2
	global388
	gHoyle4GameControls
	; 390
	global390
	global391 = 3
	global392 = 1
	global393 = 2
	gSortMode = 1
	; 395
	global395
	global396 = 15
	global397 = 14
	global398
	global399
	; 400
	gATalker
	gAniList
	global402
	global403
	global404
	; 405
	global405
	global406
	global407
	global408
	global409
	; 410
	global410
	global411
	global412
	global413
	global414
	; 415
	global415
	global416
	global417
	gCrazy8sSortCode
	global419
	; 420
	global420 = -1
	global421
	global422
	global423
	global424 = -1
	; 425
	global425
	global426
	global427
	global428
	global429
	; 430
	global430
	global431
	global432 = 1
	global433
	global434
	; 435
	global435
	global436
	global437
	global438
	global439
	; 440
	global440
	global441
	global442
	global443
	global444
	; 445
	global445
	global446
	global447
	global448
	global449
	; 450
	gTheCard1
	gTheCard2
	gTheCard3
	gTheCard4
	global454
	; 455
	gCrazy8sHand
	global456
	global457
	global458
	global459
	; 460
	gAddToTricksWon
	global461
	global462
	global463
	global464
	; 465
	global465
	global466
	global467
	global468
	global469
	; 470
	global470
	global471
	global472
	global473
	global474
	; 475
	global475
	global476
	gTrick
	gTray
	global479
	; 480
	global480
	global481
	global482
	global483
	global484
	; 485
	global485
	global486
	global487
	global488
	global489
	; 490
	global490
	global491
	global492
	global493
	global494
	; 495
	global495
	global496
	global497
	global498
	global499
	; 500
	global500
	global501
	global502
	global503
	global504
	; 505
	global505
	global506
	global507
	global508
	global509
	; 510
	global510
	global511
	global512
	global513
	global514
	; 515
	global515
	global516
	global517
	global518
	global519
	; 520
	global520
	global521
	global522
	global523
	global524
	; 525
	global525
	global526
	global527 = 4
	global528
	global529
	; 530
	global530
	global531
	global532
	global533
	global534
	; 535
	global535
	global536
	global537
	global538 = 1
	global539
	; 540
	global540
	global541
	global542
	global543
	global544
	; 545
	gWL
	gKnownCards
	global547
	global548
	global549
	; 550
	gStr
	global551
	global552
	global553
	global554
	; 555
	global555
	global556
	global557
	global558
	global559
	; 560
	global560
	global561
	global562
	global563
	global564
	; 565
	global565
	global566
	global567
	global568
	global569
	; 570
	global570
	global571
	global572
	global573
	global574
	; 575
	global575
	global576
	global577
	global578
	global579
	; 580
	global580
	global581
	global582
	global583
	global584
	; 585
	global585
	global586
	global587
	global588
	global589
	; 590
	global590
	global591
	global592
	global593
	global594
	; 595
	global595
	global596
	global597
	global598
	global599
	; 600
	global600
	global601
	global602
	global603
	global604
	; 605
	global605
	global606
	global607
	global608
	global609
	; 610
	global610
	global611
	global612
	global613
	global614
	; 615
	global615
	global616
	global617
	global618
	global619
	; 620
	global620
	global621
	global622
	global623
	global624
	; 625
	global625
	global626
	global627
	global628
	global629
	; 630
	global630
	global631
	global632
	global633
	global634
	; 635
	global635
	global636
	global637
	global638
	global639
	; 640
	global640
	global641
	global642
	global643
	global644
	; 645
	global645
	global646
	global647
	global648
	global649
	; 650
	global650
	global651
	global652
	global653
	global654
	; 655
	global655
	global656
	global657
	global658
	global659
	; 660
	global660
	global661
	global662
	global663
	global664
	; 665
	global665
	global666
	global667
	global668
	global669
	; 670
	global670
	global671
	global672
	global673
	global674
	; 675
	global675
	global676
	global677
	global678
	global679
	; 680
	global680
	global681
	global682
	global683
	global684
	; 685
	global685
	global686
	global687
	global688
	global689
	; 690
	global690
	global691
	global692
	global693
	global694
	; 695
	global695
	global696
	global697
	global698
	global699
	; 700
	global700
	global701
	global702
	global703
	global704
	; 705
	global705
	global706
	global707
	global708
	global709
	; 710
	global710
	global711
	global712
	global713
	global714
	; 715
	global715
	global716
	global717
	global718
	global719
	; 720
	global720
	global721
	global722
	global723
	global724
	; 725
	global725
	global726
	global727
	global728
	global729
	; 730
	global730
	global731
	global732
	global733
	global734
	; 735
	global735
	global736
	global737
	global738
	global739
	; 740
	global740
	global741
	global742
	global743
	global744
	; 745
	global745
	global746
	global747
	global748
	global749
	; 750
	gAllStonesObj
	gThePoints
	gTheDiceList
	global753
	global754
	; 755
	global755
	global756
	global757
	gGamePlayScript
	gTheDice1
	; 760
	gTheDice2
	gTheDice3
	gTheDice4
	gTheBar1
	gTheBar2
	; 765
	global765
	gAssocPoint
	global767 = 1300
	gBackgam_opt
	global769
	; 770
	gTheDiceCup
	gTheDoubleCube
	global772
	global773
	global774
	; 775
	global775
	global776
	global777
	gTheArrow
	global779
	; 780
	global780
	global781
	global782
	global783
	global784
	; 785
	gACast
	global786
	global787
	global788
	global789
	; 790
	global790
	global791
	global792
	global793
	global794
	; 795
	global795
	global796
	global797
	global798
	global799 = 1
	; 800
	global800
	global801
	global802
	global803
	global804
	; 805
	global805
	global806
	global807
	global808
	global809
	; 810
	global810
	global811
	global812
	global813
	global814 = 35
	; 815
	global815
	global816
	global817
	global818
	global819
	; 820
	gGameScript
	global821
	global822
	global823
	global824
	; 825
	global825
	global826
	gCheckers_opt
	global828
	global829
	; 830
	global830
	global831
	global832 = 200
	global833
	global834
	; 835
	global835
	global836
	global837
	global838
	global839
	; 840
	global840
	global841
	global842
	global843
	global844
	; 845
	global845
	global846
	global847
	global848
	global849
	; 850
	global850
	global851
	global852
	global853
	global854
	; 855
	global855
	global856
	global857
	global858
	global859
	; 860
	global860
	global861
	global862
	global863
	global864
	; 865
	global865
	global866
	global867
	global868
	global869
	; 870
	global870
	global871
	global872
	global873
	global874
	; 875
	global875
	global876
	global877
	global878
	global879
	; 880
	global880
	global881
	global882
	global883
	global884
	; 885
	gPoker_opt
	global886
	global887
	global888
	global889
	; 890
	global890
	global891
	global892
	gChipCast
	global894
	; 895
	global895
	gAttitudeSetting
	global897
	global898 = 5
	global899 = 5
	; 900
	global900
	global901
	global902
	global903
	global904
	; 905
	global905
	global906
	global907
	gChipsPlane
	global909
	; 910
	global910 = 420
	global911 = 500
	global912 = 500
	global913 = 500
	global914 = 500
	; 915
	gLooperDir8
	global916
	global917
	global918
	global919
	; 920
	global920
	global921
	global922
	global923
	global924
	; 925
	global925
)

(procedure (proc0_7 &tmp temp0)
	(while ((= temp0 (Event new: evMOUSE)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(procedure (proc0_15 &tmp temp0)
	(while ((= temp0 (Event new: $000c)) type:) ; evKEYUP | evKEYBOARD
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(procedure (proc0_6)
	(if (gAbsoluteCast size:)
		(= gGameTime (+ gTickOffset (GetTime)))
		(proc0_9 (gAbsoluteCast elements:) 1)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(if (gAbsoluteCast size:)
				(gAbsoluteCast eachElementDo: #motionCue)
			)
		)
	)
)

(procedure (RedrawCast param1)
	(proc0_9 (gCast elements:) (if argc param1 else 0))
)

(procedure (proc0_9 param1 param2 &tmp temp0 temp1 temp2)
	(FrameOut)
	(for ((= temp0 (KList 3 param1))) temp0 ((= temp0 temp1)) ; FirstNode
		(= temp1 (KList 6 temp0)) ; NextNode
		(if (= temp2 (KList 8 temp0)) ; NodeValue
			(if param2
				(temp2 doit:)
			)
			(if (not (& (temp2 signal:) $0008))
				(UpdateScreenItem temp2)
			)
		)
	)
	(FrameOut)
)

(procedure (proc0_10 param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0 temp1 temp2)
	(cond
		((<= argc 6)
			(= temp1 0)
		)
		((and (= temp1 param7) (not ((temp1 casts:) at: 0)))
			(temp1 addCast: (Cast new:))
		)
	)
	(if (<= argc 7)
		(= temp2 {drawCel})
	else
		(= temp2 param8)
	)
	(= temp0
		((View new:)
			view: param1
			loop: param2
			cel: param3
			x: param4
			y: param5
			name: temp2
			setPri: param6
			yourself:
		)
	)
	(if temp1
		(temp0 init: ((temp1 casts:) at: 0))
	else
		(temp0 init:)
	)
	(FrameOut)
	(UpdateScreenItem temp0)
)

(procedure (proc0_2 param1)
	(return (and (== (param1 type:) 4) (== (param1 message:) 13)))
)

(procedure (localproc_0)
	(= gGameControls hoyle4GameControls)
	((= gTheIconBar IconBar)
		curIcon: (ScriptID 12 0) ; gameControlIcon
		state: 1024
		add:
			((ScriptID 12 0) theObj: (ScriptID 12 0) selector: #doit yourself:) ; gameControlIcon, gameControlIcon
			((ScriptID 12 1) theObj: (ScriptID 12 1) selector: #doit yourself:) ; optionsIcon, optionsIcon
			((ScriptID 12 2) theObj: (ScriptID 12 2) selector: #doit yourself:) ; scoreIcon, scoreIcon
			((ScriptID 12 3) theObj: (ScriptID 12 3) selector: #doit yourself:) ; rulesIcon, rulesIcon
			((ScriptID 12 5) theObj: (ScriptID 12 5) selector: #doit yourself:) ; moodIcon, moodIcon
			((ScriptID 12 4) theObj: (ScriptID 12 4) selector: #doit yourself:) ; quitIcon, quitIcon
		helpIconItem: (ScriptID 12 4) ; quitIcon
	)
	(gTheIconBar init:)
)

(procedure (DisableCursor param1)
	(if
		(or
			(User controls:)
			(and argc (!= param1 gTheCursor))
			(and (not argc) (== gTheCursor 997))
		)
		(User canControl: 0 canInput: 0)
		(if (not (HaveMouse))
			(if (!= gTheCursor 997)
				(= global191 (mouseCursor x:))
				(= global192 (mouseCursor y:))
			)
			(= global190 gTheCursor)
			(gGame setCursor: (if argc param1 else 997) 1 319 199)
		else
			(= global190 gTheCursor)
			(gGame setCursor: (if argc param1 else 997) 1)
		)
	)
)

(procedure (EnableCursor)
	(if (not (User controls:))
		(User canControl: 1 canInput: 1)
		(= global190 999)
		(if (not (HaveMouse))
			(gGame setCursor: global190 1 global191 global192)
		else
			(gGame setCursor: global190)
		)
	)
)

(procedure (proc0_5 &tmp temp0)
	(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
		(Palette 2 0 255 temp0) ; PalIntensity
	)
)

(procedure (localproc_1)
	(= global375 0)
	(= global376 -1)
	(= global370 1)
)

(procedure (proc0_8 param1)
	(if
		(and
			(not global921)
			(OneOf gCurRoomNum 100 200 300 400 500 600 700 1100 1200 1300) ; crazy8s, oldMaid, heartsGame, ginRummy, cribbage, klondike, bridge, pokerRoom, checkers, backgam
		)
		(if (and argc param1)
			(PlaySong play: param1)
		else
			(gSong fade:)
		)
	)
)

(procedure (proc0_12 param1 param2 &tmp temp0 temp1)
	(if (not global921)
		(if (> argc 1)
			(= temp1 param2)
		else
			(= temp1 1)
		)
		(if (== gAttitudeSetting 0)
			(return)
		)
		(= temp0 (+ param1 (* 1000 global878)))
		(switch temp1
			(1
				(gSound play: temp0)
			)
			(2
				(gSound2 play: temp0)
			)
			(3
				(gSong play: temp0)
			)
		)
	)
)

(procedure (proc0_11 param1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
		(if (== param1 (Deck at: temp0))
			(return 1)
		)
	)
	(return 0)
)

(procedure (proc0_14)
	(return (* global899 12))
)

(class HoyleRoom of Room
	(properties)

	(method (beforeNewPic &tmp temp0)
		(return 1)
	)

	(method (afterNewPic &tmp temp0)
		(return 1)
	)

	(method (drawNewPic)
		(self drawPic: picture 0)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit: &rest)
		(if (!= (+ global385 global877) picture)
			(cond
				((!= picture -2)
					(IconBar disable:)
					(= temp1 picture)
					(= picture (+ global385 global877))
					(DisableCursor)
					(if (self beforeNewPic:)
						(for
							((= temp0 0))
							(< temp0 (gDelayCast size:))
							((++ temp0))
							
							(gCast add: (gDelayCast at: temp0))
						)
						(RedrawCast)
						(self drawNewPic:)
						(if (gChar1 active:)
							(gChar1 init:)
						)
						(if (gChar2 active:)
							(gChar2 init:)
						)
						(if (gChar3 active:)
							(gChar3 init:)
						)
						(RedrawCast)
						(for
							((= temp0 0))
							(< temp0 (gDelayCast size:))
							((++ temp0))
							
							(gCast delete: (gDelayCast at: temp0))
						)
						(self afterNewPic:)
					else
						(= picture temp1)
					)
					(EnableCursor)
					(IconBar enable:)
				)
				((!= (+ global385 global877) ((gChipCast plane:) picture:))
					((gChipCast plane:) drawPic: (+ global385 global877) 0)
				)
			)
		)
	)

	(method (dispose)
		(= global395 0)
		(gDelayCast release:)
		(super dispose:)
	)
)

(class ColorBorderWindow of Plane
	(properties)

	(method (open)
		(super init: &rest)
	)
)

(instance char1 of Character
	(properties)
)

(instance char2 of Character
	(properties)
)

(instance char3 of Character
	(properties)
)

(instance face1 of Prop
	(properties
		priority 7
	)
)

(instance face2 of Prop
	(properties
		priority 7
	)
)

(instance face3 of Prop
	(properties
		priority 7
	)
)

(instance narratorFace of Prop ; UNUSED
	(properties
		view 6
	)
)

(instance charScript1 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client cel: 0 show: setCycle: End self)
			)
			(1
				(= ticks register)
			)
			(2
				(= temp0 client)
				(client setScript: 0 hide:)
				(gChar1 init:)
				(if caller
					(caller cue:)
				)
				(RedrawCast)
			)
		)
	)
)

(instance charScript2 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client cel: 0 show: setCycle: End self)
			)
			(1
				(= ticks register)
			)
			(2
				(= temp0 client)
				(client setScript: 0 hide:)
				(gChar2 init:)
				(if caller
					(caller cue:)
				)
				(RedrawCast)
			)
		)
	)
)

(instance charScript3 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client cel: 0 show: setCycle: End self)
			)
			(1
				(= ticks register)
			)
			(2
				(= temp0 client)
				(client setScript: 0 hide:)
				(gChar3 init:)
				(if caller
					(caller cue:)
				)
				(RedrawCast)
			)
		)
	)
)

(instance hoyle4 of Game
	(properties)

	(method (init &tmp [temp0 8] temp8 temp9 temp10)
		(DoAudio 12 0) ; AudMixCheck
		(= global920 0)
		(= gScreenWidth 640)
		(= gScreenHeight 480)
		(= gLastScreenX 639)
		(= gLastScreenY 479)
		(= global919 1)
		(= gStr (Str new:))
		(= global877 901)
		(= global878 0)
		(= gTheCursor gNormalCursor)
		(= global191 319)
		(= global192 199)
		(= gHowFast 2)
		(DisableCursor)
		(localproc_1)
		(Print font: 2107 width: 220 mode: 1)
		(= gUserFont 2107)
		(= gEatMice 0)
		(= gSystemPlane HoyleWindow)
		(= gUseSortedFeatures 1)
		(User alterEgo: (= gEgo Ego))
		(super init:)
		(= gHoyle4GameControls hoyle4GameControls)
		(Dealer add:)
		((= gAniList aniList) add:)
		((= gAbsoluteCast absoluteCast) add:)
		((= gKeyDownHandler hoyle4KeyDown) add:)
		((= gMouseDownHandler hoyle4MouseDown) add:)
		((= gDirectionHandler hoyle4Direction) add:)
		((= gTheKeyMouseList theKeyMouseList) add:)
		((= gDelayCast delayCast) add:)
		(= gMouseCursor mouseCursor)
		(mouseCursor x: 319)
		(mouseCursor y: 199)
		(version doit:)
		(= gVersion global541)
		((= gGame_opt game_opt) doit: 2)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(KeyMouse init: setList: gTheKeyMouseList)
		(= gMsgType 1)
		DItem
		(if 0
			(Load 140 901) ; WAVE
			(Lock 140 901) ; WAVE
			(Load 140 902) ; WAVE
			(Lock 140 902) ; WAVE
			(Load 140 903) ; WAVE
			(Lock 140 903) ; WAVE
			(Load 140 904) ; WAVE
			(Lock 140 904) ; WAVE
			(Load 140 905) ; WAVE
			(Lock 140 905) ; WAVE
			(Load 140 906) ; WAVE
			(Lock 140 906) ; WAVE
			(Load 140 907) ; WAVE
			(Lock 140 907) ; WAVE
		)
		(ScriptID 14 0) ; setGC
		GameControls
		IconBar
		(Characters add:)
		((= gATalker aTalker) add:)
		(localproc_0)
		(= gGcWindow gcWindow)
		(= gGameControls hoyle4GameControls)
		((ScriptID 14 0) doit:) ; setGC
		(EnableCursor)
		(Characters
			add: (= gChar1 char1) (= gChar2 char2) (= gChar3 char3)
		)
		(gChar1 face: face1 charScript: charScript1)
		(gChar2 face: face2 charScript: charScript2)
		(gChar3 face: face3 charScript: charScript3)
		(= gSong song)
		(= gSound sound)
		(= gSound2 sound2)
		(gSong owner: gGame init:)
		(gSong setPri: 1)
		(sound setPri: 2)
		(sound2 setPri: 3)
		(gTheIconBar disable:)
		(= gTheCard1 theCard1)
		(= temp10 (mod (= temp9 (MemoryInfo 0)) 1024))
		(= global254
			(= temp8 (+ (= temp8 (* (/ temp9 1024) 16)) (/ (* temp10 16) 1024)))
		)
		(= global119 0)
		(self newRoom: 2) ; intro
	)

	(method (masterVolume param1)
		(if argc
			(= global897 param1)
			(DoSound sndMASTER_VOLUME param1)
		)
		(return global897)
	)

	(method (doit)
		(super doit:)
	)

	(method (setCursor param1 param2 param3 param4 param5 param6 &tmp temp0)
		(= temp0 gTheCursor)
		(if (< param1 900)
			(= param1 999)
		)
		(if (== param1 0)
			(= gTheCursor param1)
			(param1 init:)
		else
			(= gTheCursor param1)
			(SetCursor param1 0 0)
		)
		(if (> argc 1)
			(cond
				((not param2)
					(SetCursor 998 0 0)
				)
				((!= param1 -1)
					(SetCursor param1 0 0)
				)
			)
			(if (> argc 2)
				(SetCursor param3 param4)
				(if (> argc 4)
					(SetCursor param1 0 0 param5 param6)
				)
			)
		)
		(return temp0)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(event plane: 0)
		(event globalize:)
		(mouseCursor x: (event x:) y: (event y:))
	)

	(method (quitGame &tmp [temp0 10])
		(super quitGame:)
	)

	(method (restart param1)
		(if (or (not argc) param1)
			(if (Printf {Restart HOYLE 3?} 85 {YES} 1 85 {NO} 0)
				((KeyMouse objList:) release:)
				(super restart:)
			)
		else
			((KeyMouse objList:) release:)
			(super restart:)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(if (Deck size:)
			(Deck eachElementDo: #hide)
			(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
				(gCast delete: (Deck at: temp0))
			)
		)
		(gAbsoluteCast release:)
		(gGame setCursor: 997 1)
		(if (== (Platform 4 1) 1)
			(proc0_5)
		)
		(super newRoom: newRoomNumber)
	)

	(method (startRoom roomNum)
		(if gDebugOn
			(SetDebug)
		)
		(gRegions addToFront: (= gCurRoom (ScriptID roomNum)))
		(gCurRoom init:)
		(return
			(if global538
				(= global538 0)
			else
				1
			)
		)
	)
)

(instance hoyle4MouseDown of EventHandler
	(properties)

	(method (handleEvent event)
		(mouseCursor x: (event x:) y: (event y:))
		(super handleEvent: event)
		(if (and (User controls:) (not (event claimed:)) (event type:))
			(gCurRoom handleEvent: event)
		)
		(event claimed:)
	)
)

(instance hoyle4KeyDown of EventHandler
	(properties)

	(method (handleEvent event)
		(mouseCursor x: (event x:) y: (event y:))
		(super handleEvent: event)
		(if (and (User controls:) (not (event claimed:)) (event type:))
			(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
				(event claimed:)
				(return)
			)
			(gCurRoom handleEvent: event)
			(event claimed:)
			(return)
		)
	)
)

(instance aTalker of Set
	(properties)
)

(instance hoyle4Direction of EventHandler
	(properties)

	(method (handleEvent event)
		(mouseCursor x: (event x:) y: (event y:))
		(super handleEvent: event)
		(event claimed:)
	)
)

(instance theKeyMouseList of Set
	(properties)
)

(instance aniList of Set
	(properties)
)

(instance mouseCursor of Actor
	(properties)
)

(class HoyleGameControls of GameControls
	(properties
		okIconItem 0
	)

	(method (dispatchEvent event &tmp temp0)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event message: JOY_NULL claimed: 1)
			(if okIconItem
				(okIconItem doit: -1)
			)
			(return)
		)
		(super dispatchEvent: event &rest)
	)
)

(instance hoyle4GameControls of HoyleGameControls
	(properties)

	(method (show)
		(self plane: gGcWindow)
		(super show:)
	)
)

(instance gcWindow of InvisibleWindow
	(properties)

	(method (init &tmp [temp0 5])
		(self top: 53 left: 161 bottom: 309 right: 481)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(self priority: 10)
		(super init:)
		(proc0_10 901 0 0 0 0 0 self)
	)
)

(instance game_opt of File
	(properties
		name {game.opt}
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(= temp0 (Str new:))
					(self
						writeString:
							(temp0
								format:
									{%3d%2d%3d%2d%2d%d%d%d%d%d}
									(gGame masterVolume:)
									global384
									global385
									global898
									global899
									global462
									global121
									gAttitudeSetting
									global916
									global919
							)
						close:
					)
					(temp0 dispose:)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				1
				(= temp1 (Str new:))
				(self readString: temp1 4)
				(= temp2 (temp1 asInteger:))
				(gGame masterVolume: temp2)
				(self readString: temp1 3)
				(= global384 (temp1 asInteger:))
				(self readString: temp1 4)
				(= global385 (temp1 asInteger:))
				(self readString: temp1 3)
				(= global898 (temp1 asInteger:))
				(self readString: temp1 3)
				(= global899 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global462 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global121 (temp1 asInteger:))
				(self readString: temp1 2)
				(= gAttitudeSetting (temp1 asInteger:))
				(self readString: temp1 2)
				(= global916 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global919 (temp1 asInteger:))
				(self close:)
				(temp1 dispose:)
				(return 0)
			)
			(else
				(gGame masterVolume: 8)
				(= global384 0)
				(= global385 7)
				(= global916 0)
				(= gAttitudeSetting 1)
				(= global462 1)
				(= global121 1)
				(= global919 1)
				(return 0)
			)
		)
	)
)

(instance absoluteCast of Set
	(properties)
)

(instance version of File
	(properties)

	(method (doit)
		(if (self open: 1)
			(self readString: global541 6 close:)
		)
	)
)

(instance theCard1 of Actor
	(properties)
)

(instance delayCast of Set
	(properties)
)

(class PlaySong of Obj
	(properties
		nextSong 0
		client 0
		nextOverride 0
	)

	(method (play param1 param2 &tmp temp0)
		(if (not global921)
			(if (== global919 0)
				(= param1 0)
			)
			(= client (if (>= argc 2) param2 else 0))
			(if (and argc param1)
				(gSong stop: setLoop: -1)
				(if (not (gSong handle:))
					(= temp0 param1)
					(if (and (== global121 2) (<= argc 2))
						(= temp0 [global318 (Random 0 10)])
					)
					(if (== global121 3)
						(DoSound sndSUSPEND 1)
					)
					(gSong play: temp0 client)
					(if (== global121 3)
						(if (< temp0 100)
							(gSong mute: 1)
						)
						(DoSound sndSUSPEND 0)
					)
					(= nextSong (= nextOverride 0))
				else
					(= nextSong param1)
					(= nextOverride (if (>= argc 3) 1 else 0))
					(gSong fade: self)
				)
			else
				(gSong fade:)
				(= nextSong (= nextOverride 0))
			)
		)
	)

	(method (cue &tmp temp0)
		(if nextSong
			(= temp0 nextSong)
			(if (and (== global121 2) (not nextOverride))
				(= temp0 [global318 (Random 0 10)])
			)
			(if (== global121 3)
				(DoSound sndSUSPEND 1)
			)
			(gSong play: temp0 client)
			(if (== global121 3)
				(if (< temp0 100)
					(gSong mute: 1)
				)
				(DoSound sndSUSPEND 0)
			)
			(= nextOverride (= nextSong 0))
		)
	)
)

(instance song of Sound
	(properties
		flags 1
	)

	(method (play param1 param2 param3)
		(if (not global921)
			(= number param1)
			(if
				(and
					(or (not (DoSound sndGET_AUDIO_CAPABILITY)) (not (ResCheck rsAUDIO number)))
					(<= (DoSound sndGET_POLYPHONY) 11)
				)
				1
			)
			(= client (if (>= argc 2) param2 else 0))
			(if (>= argc 3)
				(super play: param3 1)
			else
				(super play: (* 12 (gGame masterVolume:)) 0)
			)
			(if (>= argc 2)
				(= client param2)
			)
		)
	)
)

(instance sound of Sound
	(properties
		flags 1
	)

	(method (play param1 param2 param3)
		(if (not global921)
			(= number param1)
			(if
				(and
					(or (not (DoSound sndGET_AUDIO_CAPABILITY)) (not (ResCheck rsAUDIO number)))
					(<= (DoSound sndGET_POLYPHONY) 11)
				)
				1
			)
			(= client (if (>= argc 2) param2 else 0))
			(if (>= argc 3)
				(super play: param3 0)
			else
				(super play: (* 12 (gGame masterVolume:)) 0)
			)
			(if (>= argc 2)
				(= client param2)
			)
		)
	)
)

(instance sound2 of Sound
	(properties
		flags 1
	)

	(method (play param1 param2 param3)
		(if (not global921)
			(= number param1)
			(if
				(and
					(or (not (DoSound sndGET_AUDIO_CAPABILITY)) (not (ResCheck rsAUDIO number)))
					(<= (DoSound sndGET_POLYPHONY) 11)
				)
				1
			)
			(= client (if (>= argc 2) param2 else 0))
			(if (>= argc 3)
				(super play: param3 1)
			else
				(super play: (* 12 (gGame masterVolume:)) 0)
			)
			(if (>= argc 2)
				(= client param2)
			)
		)
	)
)

(instance cueableScript of Script
	(properties)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0)
			(1
				(PlaySong play: 2 0 1)
			)
		)
	)
)

