;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use n008)
(use n100)
(use n101)
(use n104)
(use n105)
(use n106)
(use TargActor)
(use LoadMany)
(use Chase)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use System)

(public
	rm13 0
)

(local
	local0
)

(instance ogre of TargActor
	(properties
		y 94
		x 195
		yStep 3
		view 455
		loop 1
		cel 6
		cycleSpeed 2
		xStep 5
		moveSpeed 2
		targDeltaY -5
	)

	(method (getHurt param1)
		(if (<= (-= global333 param1) 0)
			(SetFlag 331)
			(self setScript: ogreDies)
		else
			(= global585 global333)
		)
	)
)

(instance crash of Sound
	(properties
		priority 14
	)
)

(instance rm13 of Rm
	(properties
		picture 13
		style 8
		west 12
	)

	(method (dispose)
		(SetFlag 3)
		(DisposeScript 972)
		(if (!= gNewRoomNum 455) ; ogreArena
			(= global332 0)
		)
		(super dispose:)
	)

	(method (init)
		(if (not (IsFlag 3))
			(= global585 100)
		)
		(if (== gPrevRoomNum 455) ; ogreArena
			(if (<= (= global585 global333) 0)
				(SetFlag 331)
			)
		else
			(= global333 global585)
		)
		(cond
			((not (IsFlag 331))
				(= global332 455)
				(LoadMany rsVIEW 455 456 510 521)
				(LoadMany
					rsSOUND
					(SoundFX 35)
					(SoundFX 39)
					(SoundFX 31)
					(SoundFX 66)
				)
				(LoadMany rsSCRIPT 101 972)
				(if (gEgo knows: 23) ; flameDartSpell
					(Load rsVIEW 522)
					(Load rsSCRIPT 100)
				)
				(if (gEgo knows: 20) ; dazzleSpell
					(Load rsVIEW 521)
					(Load rsSCRIPT 106)
				)
				(if (gEgo knows: 22) ; calmSpell
					(Load rsVIEW 521)
					(Load rsSCRIPT 104)
				)
				(if (gEgo knows: 17) ; openSpell
					(Load rsVIEW 521)
					(Load rsSCRIPT 105)
				)
			)
			((> gDay global586)
				(SetFlag 341)
			)
		)
		(gContMusic fade:)
		(SL enable:)
		(self setLocales: 804)
		(super init:)
		(if (IsFlag 332)
			(SetFlag 333)
		)
		(ClearFlag 160)
		(if (!= global315 4)
			(= global315 0)
		)
		(if (== global321 1)
			(= global321 2)
		)
		(if (== global322 1)
			(= global322 2)
		)
		(if (== global322 3)
			(= global322 4)
		)
		(NormalEgo)
		(gEgo init:)
		(if (== gPrevRoomNum 455) ; ogreArena
			(gEgo posn: 127 107 loop: 1 setMotion: MoveTo -20 130 cel: 4)
			(if (<= global333 0)
				(ogre posn: 60 104)
				(self setScript: ogreDies)
				(= global332 0)
			else
				(EgoGait 1 0) ; running
				(ogre init: setScript: ogreVSego)
			)
		else
			(if (IsFlag 331)
				(if (not (IsFlag 341))
					(ogre
						init:
						loop: 0
						cel: 7
						posn: global583 global584
						view: 456
						addToPic:
					)
				)
			else
				(= global333 global585)
				(ogre init: setScript: ogreVSego)
			)
			(switch gPrevRoomNum
				(14
					(gEgo posn: 200 66 setMotion: MoveTo 200 78)
				)
				(171 ; rmBear
					(gEgo posn: 200 66 setMotion: MoveTo 200 78)
				)
				(else
					(gEgo posn: 2 140 setMotion: MoveTo 35 140)
				)
			)
		)
	)

	(method (doit)
		(if (and (== (gEgo onControl: 1) 32) (== (gEgo loop:) 3))
			(gCurRoom newRoom: 14)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'rest[/!*]')
						(if (IsFlag 331)
							(EgoRests 10 1)
						else
							(HighPrint 13 0) ; "You're kidding, right?"
						)
					)
					((Said 'fight')
						(if (IsFlag 331)
							(event claimed: 0)
						else
							(gCurRoom newRoom: 455) ; ogreArena
						)
					)
					((Said 'throw/dagger,dagger')
						(= global250 0)
						(cond
							((not (gEgo has: 7)) ; dagger
								(HighPrint 13 1) ; "You don't have a knife."
							)
							((not (IsFlag 331))
								(LookAt gEgo ogre)
								(ThrowKnife ogre)
							)
							(else
								(ThrowKnife 0)
							)
						)
					)
					((Said 'search,look/troll,bandit,man')
						(HighPrint 13 2) ; "There are none here to search."
						(cond
							((IsFlag 341)
								(HighPrint 13 3) ; "The Ogre's body must have been carried away during the night by some marauding beasties."
							)
							((IsFlag 331)
								(HighPrint 13 4) ; "However, there is a dead Ogre here."
							)
							(else
								(HighPrint 13 5) ; "However, there is a very large Ogre here."
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/cave,hill,hill')
								(HighPrint 13 6) ; "There is a cave entrance large enough to admit a man."
							)
							((Said '/body,ogre,monster,creature')
								(cond
									((IsFlag 341)
										(HighPrint 13 3) ; "The Ogre's body must have been carried away during the night by some marauding beasties."
									)
									((IsFlag 331)
										(HighPrint 13 7) ; "There is a big, ugly, dead Ogre here."
									)
									(else
										(HighPrint 13 8) ; "This Ogre is in a bad mood."
										(HighPrint 13 9) ; "And big. Very BIG."
									)
								)
							)
							((Said '/chest,trunk,hasp')
								(cond
									((IsFlag 332)
										(if (IsFlag 333)
											(HighPrint 13 10) ; "The dead Ogre's chest lies open and empty."
										else
											(HighPrint 13 11) ; "The dead Ogre's chest lies open, its contents glittering brightly."
										)
									)
									((not (IsFlag 331))
										(HighPrint 13 12) ; "The Ogre is carrying a chest in his massive arms."
									)
									(else
										(HighPrint 13 13) ; "The chest has a heavy lid with a strong lock."
									)
								)
							)
						)
					)
					(
						(or
							(Said 'give/food')
							(Said 'feed/body,ogre,monster,man,creature')
						)
						(cond
							((IsFlag 341)
								(HighPrint 13 14) ; "There is nobody here."
							)
							((IsFlag 331)
								(HighPrint 13 15) ; "This Ogre will never eat again."
							)
							(else
								(HighPrint 13 16) ; "This Ogre looks like it would rather eat you."
							)
						)
					)
					((Said 'search/body,ogre,monster,enemy,creature')
						(cond
							((IsFlag 341)
								(HighPrint 13 14) ; "There is nobody here."
							)
							((IsFlag 331)
								(= local0 0)
								(self setScript: egoSearch)
							)
							(else
								(HighPrint 13 0) ; "You're kidding, right?"
							)
						)
					)
					(
						(Said
							'search,look,get/trunk,chest,contents,alm,gold,silver,loot'
						)
						(cond
							((IsFlag 341)
								(HighPrint 13 14) ; "There is nobody here."
							)
							((IsFlag 331)
								(if (IsFlag 332)
									(= local0 4)
								else
									(= local0 3)
								)
								(gEgo setScript: egoSearch)
							)
							(else
								(HighPrint 13 0) ; "You're kidding, right?"
							)
						)
					)
					(
						(or
							(Said 'unlock,lockpick/chest,hasp,keyhole')
							(Said 'use/key,lockpick,(implement,kit<thief)')
							(Said 'open/hasp,keyhole,chest')
						)
						(cond
							((IsFlag 341)
								(HighPrint 13 17) ; "There are no locks here."
							)
							((IsFlag 332)
								(HighPrint 13 18) ; "It's already unlocked."
							)
							((not (IsFlag 331))
								(HighPrint 13 0) ; "You're kidding, right?"
							)
							((not [gEgoStats 9]) ; pick locks
								(HighPrint 13 19) ; "It's locked -- you'll have to use another skill to open this."
							)
							((not (CanPickLocks))
								(HighPrint 13 20) ; "You don't have the right tools -- you'll have to find another way to open it."
							)
							((TrySkill 9 0 global189) ; pick locks
								(= local0 1)
								(gEgo setScript: egoSearch)
							)
							(else
								(HighPrint 13 21) ; "The lock is beyond your current skill."
							)
						)
					)
					((Said 'force,break/chest,hasp,lid')
						(cond
							((IsFlag 341)
								(HighPrint 13 22) ; "There's nothing like that here."
							)
							((IsFlag 332)
								(HighPrint 13 18) ; "It's already unlocked."
							)
							((not (IsFlag 331))
								(HighPrint 13 0) ; "You're kidding, right?"
							)
							(else
								(= local0 2)
								(gEgo setScript: egoSearch)
							)
						)
					)
					((Said 'cast>')
						(= temp0 (SaidSpell event))
						(if (CastSpell temp0)
							(switch temp0
								(18
									(HighPrint 13 23) ; "A magical aura emanates from the cave's entrance."
								)
								(20
									(if (CastDazzle)
										(cond
											((IsFlag 341)
												(HighPrint 13 24) ; "You've wasted a spell."
											)
											((IsFlag 331)
												(HighPrint 13 25) ; "Ok, he'll be a dazzled cadaver."
											)
											(else
												(ogre setScript: ogreCalmed)
											)
										)
									)
								)
								(23
									(if (IsFlag 331)
										(CastDart 0)
									else
										(CastDart ogre)
									)
								)
								(22
									(if (CastCalm)
										(cond
											((IsFlag 341)
												(HighPrint 13 24) ; "You've wasted a spell."
											)
											((IsFlag 331)
												(HighPrint 13 26) ; "How much more calm can he get?"
											)
											(else
												(ogre setScript: ogreCalmed)
											)
										)
									)
								)
								(17
									(CastOpen)
									(cond
										((IsFlag 341)
											(HighPrint 13 27) ; "You're wasting a spell."
											(HighPrint 13 28) ; "There's nothing here to open."
										)
										((IsFlag 331)
											(cond
												((IsFlag 332)
													(HighPrint 13 27) ; "You're wasting a spell."
													(HighPrint 13 29) ; "The Ogre's chest is already unlocked."
												)
												((> [gEgoStats 17] 10) ; openSpell
													(HighPrint 13 30) ; "Your spell unlocks the Ogre's chest."
													(SetFlag 332)
												)
												(else
													(HighPrint 13 31) ; "Your spell is too weak to open the Ogre's chest."
												)
											)
										)
										(else
											(HighPrint 13 32) ; "The chest is held shut by the Ogre's massive arms."
										)
									)
								)
								(21
									(= global250 (+ 1 (/ [gEgoStats 21] 10))) ; zapSpell
									(if (or (gEgo has: 7) (gEgo has: 6)) ; dagger, blade
										(HighPrint 13 33) ; "Your weapon is now magically charged."
									else
										(HighPrint 13 34) ; "You don't seem to have a weapon to charge."
									)
								)
								(24
									(HighPrint 13 35) ; "You want to fetch THAT?"
								)
								(else
									(event claimed: 0)
								)
							)
						)
					)
					((Said 'get,grab/club,weapon')
						(cond
							((IsFlag 341)
								(HighPrint 13 22) ; "There's nothing like that here."
							)
							((IsFlag 331)
								(HighPrint 13 36) ; "The dead Ogre's huge club is much too heavy for you to lift."
							)
							(else
								(HighPrint 13 0) ; "You're kidding, right?"
							)
						)
					)
				)
			)
		)
	)
)

(instance ogreVSego of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 12)
			)
			(1
				(ogre setCycle: Walk setMotion: Chase gEgo 46 self)
			)
			(2
				(HandsOn)
				(if (not (IsFlag 331))
					(HighPrint 13 37) ; "Hostile intent is evident. You prepare for battle."
					(gCurRoom newRoom: 455) ; ogreArena
				)
			)
		)
	)
)

(instance ogreDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global586 gDay)
				(ogre
					view: 456
					loop: 0
					cel: 0
					illegalBits: 0
					init:
					setCycle: End self
				)
			)
			(1
				(crash number: (SoundFX 66) init: play:)
				(ShakeScreen 3 ssLEFTRIGHT)
				(HandsOn)
				(SetFlag 331)
				(= global583 (ogre x:))
				(= global584 (ogre y:))
				(ogre addToPic:)
				(client setScript: 0)
			)
		)
	)
)

(instance egoSearch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo inRect: 151 19 222 79)
					(HighPrint 13 38) ; "You need to get closer to the dead Ogre."
					(client setScript: 0)
				else
					(HandsOff)
					(gEgo
						ignoreActors:
						illegalBits: 0
						setMotion:
							MoveTo
							(+ global583 1)
							(if (< (gEgo y:) global584)
								(- global584 8)
							else
								(+ global584 1)
							)
							self
					)
				)
			)
			(1
				(LookAt gEgo ogre)
				(gEgo
					loop: (mod (+ (gEgo loop:) 4) 2)
					view: 510
					setCycle: End self
				)
			)
			(2
				(switch local0
					(0
						(HighPrint 13 39) ; "A search of the dead Ogre's body produces no treasure."
						(HighPrint 13 40) ; "However, the treasure chest he was carrying lies beside his body."
					)
					(1
						(HighPrint 13 41) ; "The lock on the Ogre's chest clicks open."
						(SetFlag 332)
						(HighPrint 13 42) ; "The dead Ogre's chest contains 1 gold and 43 silver, which you take and put away."
						(SetFlag 333)
						(gEgo get: 2 1) ; gold
						(gEgo get: 1 43) ; silver
					)
					(2
						(HighPrint 13 43) ; "You force the Ogre's chest open."
						(SetFlag 332)
						(HighPrint 13 42) ; "The dead Ogre's chest contains 1 gold and 43 silver, which you take and put away."
						(SetFlag 333)
						(gEgo get: 2 1) ; gold
						(gEgo get: 1 43) ; silver
					)
					(3
						(HighPrint 13 44) ; "The chest is locked."
					)
					(4
						(if (IsFlag 333)
							(HighPrint 13 45) ; "The dead Ogre's chest is empty."
						else
							(HighPrint 13 42) ; "The dead Ogre's chest contains 1 gold and 43 silver, which you take and put away."
							(SetFlag 333)
							(gEgo get: 2 1) ; gold
							(gEgo get: 1 43) ; silver
						)
					)
				)
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo)
				(HandsOn)
			)
		)
	)
)

(instance ogreCalmed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ogre setMotion: 0 cel: 2)
				(RedrawCast)
				(= seconds 14)
			)
			(1
				(HighPrint 13 46) ; "The Ogre appears to have recovered from your spell."
				(client setScript: ogreVSego)
			)
		)
	)
)

