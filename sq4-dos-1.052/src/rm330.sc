;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm330 0
)

(instance rm330 of SQRoom
	(properties
		picture 330
		style 41
	)

	(method (init)
		(Load rsVIEW 330)
		(gLongSong number: 60 vol: 127 loop: -1 flags: 1)
		(LoadMany rsSOUND 126 133)
		(theArea init:)
		(super init:)
		(pillar init:)
		(proc0_14 10)
		(guard init:)
		(sub setScript: subScript)
	)
)

(instance subScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(User canControl: 0)
				(gNarrator disable: 0)
				(sub setCycle: Fwd init: setMotion: MoveTo 106 101)
				(subTop init: setMotion: MoveTo 103 103 self)
			)
			(1
				(gLongSong2 stop:)
				(soundFX play:)
				(= seconds 3)
			)
			(2
				(soundFX number: 133 play:)
				(hatch init: setCycle: End self)
			)
			(3
				(= cycles 10)
			)
			(4
				(gEgo
					init:
					normal: 0
					view: 321
					x: 120
					y: 109
					loop: 8
					cel: 0
					cycleSpeed: 0
					setPri: 6
					illegalBits: 0
					setCycle: End self
				)
			)
			(5
				(gEgo
					normal: 1
					view: 0
					posn: 134 104
					illegalBits: 0
					setPri: 6
					illegalBits: $1f40
					setCycle: Walk
					setMotion: MoveTo 202 91
				)
				(= cycles 20)
			)
			(6
				(gLongSong playBed: hold: 1)
				(zondra init: setCycle: End self)
			)
			(7
				(zondra
					view: 331
					setLoop: 2
					setCycle: Walk
					setPri: 6
					posn: 137 99
					setMotion: MoveTo 205 87 self
				)
				(gEgo setMotion: MoveTo 335 96)
			)
			(8
				(zondra setMotion: MoveTo 340 96)
				(guard
					view: 331
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 345 96 self
				)
				(= cycles 1)
			)
			(9
				(= cycles 25)
			)
			(10
				(gCurRoom newRoom: 335)
			)
		)
	)
)

(instance sub of Actor
	(properties
		x -22
		y 101
		description {submarine}
		sightAngle 180
		lookStr {This is the submarine which you cruised in aboard.}
		yStep 1
		view 330
		priority 3
		signal 18448
		xStep 2
	)
)

(instance subTop of Actor
	(properties
		x -25
		y 103
		description {submarine}
		sightAngle 180
		lookStr {This is the submarine which you cruised in aboard.}
		yStep 1
		view 330
		loop 1
		cel 4
		priority 3
		signal 22544
		xStep 2
	)
)

(instance hatch of Prop
	(properties
		x 125
		y 104
		description {hatch}
		sightAngle 180
		lookStr {It's a nifty entry/exit device.}
		view 330
		loop 2
		priority 5
		signal 18448
		cycleSpeed 1
	)
)

(instance guard of Actor
	(properties
		x 227
		y 103
		description {latex babe}
		sightAngle 180
		lookStr {Hmm. You wonder if she has a boyfriend.}
		yStep 3
		view 331
		priority 6
		xStep 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Do
				(Print 330 0) ; "You'd better not. She looks like she knows how to use that gun."
			)
			(4 ; Talk
				(Print 330 1) ; "Talking isn't getting you anywhere with her."
			)
			(10 ; Taste
				(Print 330 2) ; "Use and lose it buddy!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance zondra of Actor
	(properties
		x 114
		y 85
		description {latex babe}
		sightAngle 180
		lookStr {What a babe!}
		yStep 3
		view 321
		loop 9
		priority 7
		signal 16
		xStep 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Do
				(Print 330 3) ; "That isn't a good idea, she seems to hate you with a passion for some strange reason."
			)
			(4 ; Talk
				(Print 330 4) ; "Your efforts at conversation are rewarded with a hateful glare."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance soundFX of Sound
	(properties
		number 126
	)
)

(instance theArea of Feature
	(properties
		x 156
		y 10
		nsBottom 200
		nsRight 320
		description {sea cave}
		sightAngle 180
		lookStr {Wow. It looks like they have quite a fortress here.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Smell
				(Print 330 5) ; "There is a faint odor of perfume mixed with the salty sea air."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pillar of Feature
	(properties
		x 292
		y 110
		nsTop 28
		nsLeft 275
		nsBottom 125
		nsRight 319
		description {support beam}
		sightAngle 180
		lookStr {One of the many massive support pillars in the fortress.}
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb)
	)
)

