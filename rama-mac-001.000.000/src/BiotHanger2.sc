;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2053)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	BiotHanger2 0
)

(instance BiotHanger2 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2054 ; BiotHanger3
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2174
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(defaultExit nextRoom: 2052 init:)
		(centipede_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2175
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(mantis_90 init:)
		(crane_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2176
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (proc1111_24 119)
			(gCurRoom setScript: spider_Pacing)
		else
			(if (== (proc70_9 46) 2054)
				(ladder init: global117)
			)
			(= picture 2188)
		)
		(super init: &rest)
		(defaultExit nextRoom: 2054 init:)
		(biotDesigns_180 init:)
		(if (== (proc70_9 46) 2054)
			(spider_180 init:)
		)
		(crane_180 init:)
		(shark_180 init:)
	)

	(method (dispose)
		(if (proc1111_24 119)
			(= global161
				(if gAutoRobot
					(Robot 11) ; FrameNum
				else
					0
				)
			)
			(proc1111_6)
			(spider_Pacing dispose:)
		)
		(super dispose: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2177
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(crab_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance spider_Pacing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (SetFlag 68))
					(proc1111_31 24)
				)
				(proc1111_7 2176 180 119 global161 0 -1 1 self)
			)
			(1
				(= global161 0)
				(self changeState: 0)
			)
		)
	)
)

(instance ladder of View
	(properties
		x 330
		y 174
		view 2020
		cel 2
	)
)

(instance crab_270 of Feature
	(properties
		noun 17
		nsTop 114
		nsRight 588
		nsBottom 242
		x 294
		y 178
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance biotDesigns_180 of Feature
	(properties
		noun 21
		nsLeft 230
		nsTop 99
		nsRight 363
		nsBottom 117
		x 296
		y 108
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance spider_180 of Feature
	(properties
		noun 19
		nsLeft 192
		nsTop 126
		nsRight 445
		nsBottom 174
		x 318
		y 150
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 119)
			(= noun 20)
			(= case 1)
		)
		(self setHotspot: 144)
	)
)

(instance crane_180 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 428 113 429 95 456 88 455 71 484 67 494 47 363 49 366 31 381 20 539 23 592 16 594 190 554 190 480 176
					yourself:
				)
		)
	)
)

(instance shark_180 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 98 82 99 182 119 181 175 165 183 123 183 122 191 84 206 1 206
					yourself:
				)
		)
	)
)

(instance mantis_90 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 68 43 67 68 144 89 142 96 93 108 86 116 87 129 127 145 109 148 82 157 67 177 65 187 79 194 95 213 88 221 105 221 144 245 168 249 191 212 220 -2 216
					yourself:
				)
		)
	)
)

(instance crane_90 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 268 202 283 164 284 89 343 86 349 2 493 1 495 22 525 34 527 60 512 80 518 165 540 197 497 209 475 202 438 186 433 143 321 146 323 172 331 205 323 207
					yourself:
				)
		)
	)
)

(instance centipede_0 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 52 152 193 146 201 171 144 188
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 399 146 442 146 533 158 536 186 452 186 395 174
					yourself:
				)
		)
	)
)
