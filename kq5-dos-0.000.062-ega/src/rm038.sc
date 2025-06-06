;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use Interface)
(use Waters)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm038 0
)

(local
	[local0 16] = [192 147 281 115 288 32 71 137 9 83 140 33 41 32 11 110]
	local16
	local17
	local18
	local19
	local20
	[local21 3] = [161 54 80]
	[local24 26] = [194 189 234 180 145 180 149 175 202 175 200 167 138 168 137 164 188 159 191 150 150 150 319 0 319 189]
	[local50 16] = [133 189 136 175 110 173 91 155 128 153 149 149 0 0 0 189]
	local66
	local67
)

(instance rm038 of Rm
	(properties
		picture 38
		south 36
	)

	(method (init)
		(super init:)
		(self setFeatures: cave)
		(gFeatures eachElementDo: #init)
		(if (> global81 1)
			(water init:)
		)
		(gGlobalSound number: 112 loop: -1 vol: 127 play:)
		(gEgo view: 10 posn: 160 186 offset: 2 init:)
		(glint cycleSpeed: 1 init: setScript: sparkle)
		(if (not (gEgo has: 21)) ; Crystal
			(crystal init:)
		)
		(if (== global81 3)
			(waterLeft init:)
		)
		((= local18 (Act new:))
			view: 561
			posn: 295 -2
			yStep: 4
			setLoop: 2
			setPri: 1
			ignoreActors: 1
			ignoreHorizon: 1
			illegalBits: 0
			setMotion: MoveTo 295 111
			init:
		)
		((= local19 (Act new:))
			view: 561
			yStep: 4
			setLoop: 2
			setPri: 1
			ignoreActors: 1
			ignoreHorizon: 1
			illegalBits: 0
			init:
			hide:
		)
		((= local20 (Act new:))
			view: 561
			yStep: 4
			setLoop: 2
			setPri: 1
			ignoreActors: 1
			ignoreHorizon: 1
			illegalBits: 0
			setMotion: MoveTo 295 111
			init:
			hide:
		)
		(poly1 points: @local24 size: 13)
		(poly2 points: @local50 size: 8)
		(self addObstacle: poly1 poly2)
	)

	(method (doit &tmp temp0)
		(if (not (local18 mover:))
			(local18 posn: 295 0 setMotion: MoveTo 295 111)
		)
		(if (and (> (local18 y:) 34) (not (local19 mover:)))
			(local19 posn: 295 0 setMotion: MoveTo 295 111 show:)
		)
		(if (and (> (local18 y:) 70) (not (local20 mover:)))
			(local20 posn: 295 0 setMotion: MoveTo 295 111 show:)
		)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
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
		(gGlobalSound fade:)
		(DisposeScript 401)
		(super dispose:)
	)
)

(instance sparkle of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (gGlobalSound prevSignal:) 10)
			(gGlobalSound prevSignal: 0)
			(self init:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (Random 0 7))
				(client
					show:
					x: [local0 (* temp0 2)]
					y: [local0 (+ (* temp0 2) 1)]
					setCycle: End self
				)
			)
			(1
				(client hide:)
			)
		)
	)
)

(instance hammerCrystal of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 3) (!= (gEgo cel:) 4) local67)
			(= local67 0)
		)
		(if (and (== state 3) (== (gEgo cel:) 4) (not local67) local66)
			(= local67 1)
			(gGlobalSound4 number: 113 loop: 1 vol: 127 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 137 152 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 562
					setLoop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: CT 3 1 self
				)
			)
			(2
				(if local66
					(gEgo setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(3
				(if local66
					(gEgo setLoop: 1 cycleSpeed: 1 setCycle: Fwd)
				else
					(gEgo setLoop: 5 cycleSpeed: 1 setCycle: Fwd)
				)
				(= seconds 5)
			)
			(4
				(if local66
					(gEgo setCycle: End self)
				else
					(gEgo setLoop: 0 cel: 3 setCycle: Beg self)
				)
			)
			(5
				(if local66
					(gGlobalSound4 number: 114 loop: 1 vol: 127 play:)
					(gEgo cel: (- (gEgo cel:) 1))
					(crystal setCycle: End self)
				else
					(gEgo
						view: 10
						normal: 1
						setLoop: -1
						cycleSpeed: 0
						illegalBits: $8000
						setCycle: Walk
					)
					((gEgo head:) show:)
					(PrintDC 38 0) ; "As strong as he is, even Graham can't break the stubborn crystal with his bare hands."
					(HandsOn)
					(client setScript: 0)
				)
			)
			(6
				(crystal setStep: 1 5 setMotion: MoveTo 152 149 self)
				(gGlobalSound3 number: 85 loop: 1 vol: 127 play:)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(gEgo
					setLoop: 0
					cel: (- (NumCels gEgo) 1)
					setCycle: Beg self
				)
			)
			(9
				(gEgo
					view: 10
					normal: 1
					setLoop: -1
					cycleSpeed: 0
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 148 149 self
				)
				((gEgo head:) show:)
			)
			(10
				((gEgo head:) hide:)
				(gEgo
					view: 562
					setLoop: 3
					cycleSpeed: 3
					normal: 0
					setCycle: End self
				)
			)
			(11
				(PrintDC 38 1 #at 40 10) ; "So very gently, Graham hits the beautiful crystal several times with his hammer until it breaks loose in one piece. He carefully places it among his other possessions."
				(SetScore 4)
				(crystal dispose:)
				(gEgo get: 21 setCycle: Beg self) ; Crystal
			)
			(12
				(gEgo
					view: 10
					normal: 1
					setLoop: -1
					cycleSpeed: 0
					illegalBits: $8000
					setCycle: Walk
				)
				((gEgo head:) show:)
				(= local66 0)
				(= cycles 3)
			)
			(13
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance glint of Prop
	(properties
		view 561
		loop 3
		priority 15
		signal 16400
	)
)

(instance cave of RFeature
	(properties
		nsBottom 200
		nsRight 320
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
					(PrintDC 38 2) ; "Crystals flashing and sparkling, and reflecting off the numerous waterfalls, cause Graham to gaze in awe at the dazzling spectacle before him."
					(event claimed: 1)
				)
				(3 ; Do
					(if (and (not (gEgo has: 21)) (not local16)) ; Crystal
						(++ local16)
						(PrintDC 38 3) ; "One especially beautiful crystal catches Graham's notice in the center of the crystal cave."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance crystal of Act
	(properties
		y 138
		x 153
		view 562
		loop 2
		signal 16384
		cycleSpeed 2
		illegalBits 0
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
					(PrintDC 38 4) ; "One particularly brilliant crystal catches Graham's attention among all the other glittering crystals in the cave."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local17)
						(++ local17)
						(gCurRoom setScript: hammerCrystal)
						(event claimed: 1)
					)
				)
				(5 ; Inventory
					(event claimed: 1)
					(switch global69
						(22 ; Hammer
							(= local66 1)
							(gCurRoom setScript: hammerCrystal)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 38 5) ; "It won't help Graham retrieve the crystal."
						)
					)
				)
			)
		)
	)
)

(instance waterLeft of Act
	(properties
		y 156
		x 24
		view 561
		loop 1
		priority 1
		signal 26640
		cycleSpeed 1
	)

	(method (doit)
		(super doit:)
		(if (== (self y:) 156)
			(self
				y: (Random 128 140)
				x: (Random 24 28)
				setMotion: MoveTo (self x:) 156
			)
		)
	)
)

(instance water of Waters
	(properties
		view 561
		priority 1
		signal 24624
		cycleSpeed 1
		pos 0
		wfCels 6
	)

	(method (getLoop)
		(= x [local21 pos])
		(= y [local21 (++ pos)])
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

