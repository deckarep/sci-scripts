;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm140 0
)

(local
	seenMsg
)

(instance rm140 of LLRoom
	(properties
		picture 140
	)

	(method (init)
		(LoadMany rsVIEW 140 141 1142 1143 1140)
		(LoadMany rsSOUND 140)
		(HandsOff)
		(super init:)
		(fScruemall init: setPri: 3)
		(pornGeek1 init:)
		(pornGeek2 init:)
		(geek3 init:)
		(geek4 init:)
		(geek4a init:)
		(geek5 init:)
		(geek6 init:)
		(geek6a init:)
		(geek7 init:)
		(gAddToPics doit:)
		(SetFFRoom 155)
		(gTheMusic number: 140 flags: 1 setLoop: -1 play:)
		(if (== gPrevRoomNum 130)
			(self setScript: sCartoon)
		else
			(= style 11)
			(self setScript: sLarryCartoon)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 160)
			(gTheMusic fade: 0 15 12 1)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fScruemall of Prop
	(properties
		x 158
		y 55
		view 144
		cel 2
	)
)

(instance pornGeek1 of PicView
	(properties
		x 63
		y 81
		view 142
		priority 7
		signal 16
	)
)

(instance pornGeek2 of PicView
	(properties
		x 249
		y 75
		view 143
		priority 7
		signal 16
	)
)

(instance geek3 of PicView
	(properties
		x 53
		y 110
		view 140
		priority 8
	)
)

(instance geek5 of PicView
	(properties
		x 267
		y 114
		view 140
		loop 1
		priority 9
	)
)

(instance geek4 of PicView
	(properties
		x 221
		y 159
		view 140
		loop 2
		cel 1
	)
)

(instance geek4a of PicView
	(properties
		x 236
		y 128
		view 140
		loop 2
		priority 14
		signal 16
	)
)

(instance geek6 of PicView
	(properties
		x 103
		y 154
		view 140
		loop 3
		cel 1
		priority 13
		signal 16
	)
)

(instance geek6a of PicView
	(properties
		x 89
		y 126
		view 140
		loop 3
		priority 14
		signal 16
	)
)

(instance geek7 of PicView
	(properties
		x 157
		y 128
		view 140
		loop 4
	)
)

(instance Biffie of Talker
	(properties
		nsTop 113
		nsLeft 3
		view 1142
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust geek1Bust)
		(= eyes geek1Eyes)
		(= mouth geek1Mouth)
		(super init: &rest)
	)
)

(instance geek1Bust of Prop
	(properties
		view 1142
		loop 1
	)
)

(instance geek1Eyes of Prop
	(properties
		nsTop 15
		nsLeft 10
		view 1142
		loop 2
		cycleSpeed 70
	)
)

(instance geek1Mouth of Prop
	(properties
		nsTop 36
		nsLeft 26
		view 1142
		cycleSpeed 5
	)
)

(instance Scooter of Talker
	(properties
		nsTop 113
		nsLeft 48
		view 1143
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust geek2Bust)
		(= eyes geek2Eyes)
		(= mouth geek2Mouth)
		(super init: &rest)
	)
)

(instance geek2Bust of Prop
	(properties
		view 1143
		loop 1
	)
)

(instance geek2Eyes of Prop
	(properties
		nsTop 34
		nsLeft 23
		view 1143
		loop 2
		cycleSpeed 70
	)
)

(instance geek2Mouth of Prop
	(properties
		nsTop 40
		nsLeft 16
		view 1143
		cycleSpeed 5
	)
)

(instance Silas_Scruemall of Talker
	(properties
		name {Silas Scruemall}
		nsTop 106
		nsLeft 40
		view 1140
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust ScruemallBust)
		(= eyes ScruemallEyes)
		(= mouth ScruemallMouth)
		(super init: &rest)
	)
)

(instance ScruemallBust of Prop
	(properties
		view 1140
		loop 1
	)
)

(instance ScruemallEyes of Prop
	(properties
		nsTop 31
		nsLeft 13
		view 1140
		loop 2
		cycleSpeed 70
	)
)

(instance ScruemallMouth of Prop
	(properties
		nsTop 53
		nsLeft 8
		view 1140
		cycleSpeed 5
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say Biffie 140 0 #dispose #caller self) ; "And so," a corporate yes man continues, "I'm pleased to say our contest to find `The Sexiest Woman in America' to serve as the hostess on `America's Sexiest Home Videos' has been a resounding success!"
			)
			(1
				(= ticks 60)
			)
			(2
				(Say Biffie 140 1 #dispose #caller self) ; "The character portrayed by our hostess, whom we've decided to name `Vanna Black,' will be one exceptional woman!"
			)
			(3
				(= ticks 60)
			)
			(4
				(Say Biffie 140 2 #dispose #caller self) ; "We've searched for a woman, beautiful, yet with those All-American, girl-next-door looks; a woman virginal and untouchable; and yet, a woman who is sexy and slutty."
			)
			(5
				(= ticks 60)
			)
			(6
				(Say Biffie 140 3 #dispose #caller self) ; "We've received thousands of submissions, and (thanks to hard work by me and my colleagues) narrowed the field down to three finalists."
			)
			(7
				(= ticks 60)
			)
			(8
				(Say Biffie 140 4 #dispose #caller self) ; "I intend to have these women flown here, first class, wined and dined in regal style, then outfitted with the finest fashions Rodeo Drive has to offer."
			)
			(9
				(= ticks 60)
			)
			(10
				(Say Biffie 140 5 #dispose #caller self) ; "They'll want for nothing! And, on the morning of the auditions, champagne baths for all! I've arranged national press coverage, of course."
			)
			(11
				(= ticks 60)
			)
			(12
				(Say Biffie 140 6 #dispose #caller self) ; "In short, everything is proceeding according to schedule."
			)
			(13
				(= ticks 60)
			)
			(14
				(fScruemall setCel: 1)
				(= seconds 3)
			)
			(15
				(TPrint 140 7) ; "There is a polite smattering of applause from the the other lackeys around the conference table."
				(= seconds 3)
			)
			(16
				(fScruemall setCel: 2)
				(= ticks 100)
			)
			(17
				(Say Silas_Scruemall 140 8 #dispose #caller self) ; "But wait, Biffie. We all know that if we bring these women to Hollywood to audition under those circumstances, they'll all be sexy."
			)
			(18
				(fScruemall setCel: 1)
				(= ticks 60)
			)
			(19
				(TPrint 140 9 #at 68 91 #title {A Yes Man}) ; "Yes sir, Mr. Scruemall!"
				(TPrint 140 10 #at 105 137 #title {A Yes Man}) ; "Isn't that what we wanted, Mr. Scruemall?"
				(TPrint 140 11 #at 180 113 #title {A Yes Man}) ; "Bravo, Mr. Scruemall!"
				(= seconds 3)
			)
			(20
				(Say Silas_Scruemall 140 12 #dispose #caller self) ; ""But, we're looking for a woman so over-sexed she'd drop (what's she's doing) for any man, any time, any place, and for any loser, any dork, no matter how lame!"
			)
			(21
				(= ticks 60)
			)
			(22
				(TPrint 140 9 #at 180 147 #title {A Yes Man}) ; "Yes sir, Mr. Scruemall!"
				(TPrint 140 10 #at 0 147 #title {A Yes Man}) ; "Isn't that what we wanted, Mr. Scruemall?"
				(TPrint 140 11 #at 68 91 #title {A Yes Man}) ; "Bravo, Mr. Scruemall!"
				(= seconds 3)
			)
			(23
				(Say Silas_Scruemall 140 13 #dispose #caller self) ; "I've changed my mind! Now I think we should hold a blind audition, where the women don't know they're being auditioned!"
			)
			(24
				(= ticks 60)
			)
			(25
				(fScruemall setCel: 0)
				(TPrint 140 9 #at 105 137 #title {A Yes Man}) ; "Yes sir, Mr. Scruemall!"
				(TPrint 140 10 #at 180 113 #title {A Yes Man}) ; "Isn't that what we wanted, Mr. Scruemall?"
				(TPrint 140 11 #at 180 147 #title {A Yes Man}) ; "Bravo, Mr. Scruemall!"
				(= seconds 3)
			)
			(26
				(Say Scooter 140 14 #dispose #caller self) ; "But (with all due respects, Mr. Scruemall) that's impossible. We need videotapes of their auditions for our own, uh, personal review purposes. There's no way we could follow the guy around without her seeing us!"
			)
			(27
				(= seconds 3)
			)
			(28
				(Say Silas_Scruemall 140 15 #dispose #caller self) ; "Well, yes, we do need those tapes to review. But what if we could find an auditioner so inept, so sexless, so lame, so unappealing, that it would take the sexiest woman in America to find him attractive?"
			)
			(29
				(fScruemall setCel: 1)
				(= ticks 60)
			)
			(30
				(TPrint 140 16 #at 0 147 #title {A Yes Man}) ; "Great idea, Mr. Scruemall!"
				(TPrint 140 17 #at 68 91 #title {A Yes Man}) ; "Of course, Mr. Scruemall!"
				(TPrint 140 18 #at 105 137 #title {A Yes Man}) ; "Masterful stroke, Mr. Scruemall!"
				(fScruemall setCel: 0)
				(= seconds 4)
			)
			(31
				(Say Scooter 140 19 #dispose #caller self) ; "But, Sil--, er, Mr. Scruemall! How will we ever find somebody so lame?"
			)
			(32
				(fScruemall setCel: 0)
				(= ticks 150)
			)
			(33
				(gTheIconBar disable:)
				(gCast eachElementDo: #dispose)
				(DrawPic 1 -32762)
				(= seconds 3)
			)
			(34
				(gTheIconBar enable:)
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance sLarryCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fScruemall setCel: 1)
				(gEgo
					init:
					x: 319
					y: 69
					view: 141
					setCycle: Walk
					loop: 1
					setMotion: MoveTo 217 56 self
				)
			)
			(1
				(Say gEgo 140 20) ; "Hi, guys!" you say cheerfully. "So, who wanted java?"
				(= cycles 10)
			)
			(2
				(Say Silas_Scruemall 140 21 #dispose #caller self) ; "You may begin with me, boy."
			)
			(3
				(TPrint 140 22 #at -1 185) ; "(So you decide to do exactly that!)"
				(gEgo setMotion: MoveTo 190 53 self)
			)
			(4
				(gEgo setMotion: MoveTo 125 53 self)
			)
			(5
				(fScruemall setCel: 2)
				(gEgo setCel: 0 y: 55 setLoop: 2 setCycle: End self)
			)
			(6
				(Say gEgo 140 23) ; "Here you go, Mr. Scruemall," you say in your best suck-up tone of voice. "May I freshen that for you?"
				(gCurRoom newRoom: 150)
			)
		)
	)
)

