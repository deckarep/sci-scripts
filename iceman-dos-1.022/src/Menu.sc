;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use User)

(class MenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } { About Iceman `^a: Help`#1 })
		(AddMenu
			{ File }
			{ Save Game`#5: Restore Game`#7: --!: Restart Game`#9: Quit`^q }
		)
		(AddMenu { Action } { Pause Game`^p: Inventory`^I: Repeat`#3 })
		(AddMenu { Speed } { Set Speed`^s: --!: Faster`+: Normal`=: Slower`- })
		(AddMenu { Sound } { Volume...`^v: Turn Off`#2=1 })
		(SetMenu 258 109 'help[/!*]')
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 517 109 'quit[/game]')
		(SetMenu 769 109 'pause')
		(SetMenu 770 109 '/inventory')
	)

	(method (handleEvent event &tmp temp0 [temp1 100] temp101)
		(switch (super handleEvent: event)
			(257
				(Print
					(Format @temp1 997 0 gVersion) ; "VERSION: %s"
					#title
					{__Iceman Credits__}
					#mode
					1
					#width
					160
					#font
					gSmallFont
				)
				(Print
					(Format @temp1 997 1) ; "DESIGNED BY: Jim Walls"
					#title
					{__Iceman Credits__}
					#mode
					1
					#width
					160
					#font
					gSmallFont
				)
				(Print
					(Format @temp1 997 2) ; "ILLUSTRATED BY: Cheryl Loyd Jim Larsen Jerry Moore Cindy Walker Jeff Crowe Kenn Nishiuye"
					#title
					{__Iceman Credits__}
					#mode
					1
					#width
					160
					#font
					gSmallFont
				)
				(Print
					(Format @temp1 997 3) ; "PROGRAMMED BY: J.Mark Hood Doug Oldfield Larry Scott Pablo Ghenis Carlos Escobar Robert Lindsley David Skinner"
					#title
					{__Iceman Credits__}
					#mode
					1
					#width
					160
					#font
					gSmallFont
				)
				(Print
					(Format @temp1 997 4) ; "QUALITY ASSURANCE BY: Mike Harian Jennifer Cobb"
					#title
					{__Iceman Credits__}
					#mode
					1
					#width
					160
					#font
					gSmallFont
				)
			)
			(258
				(Print 997 5 #font gSmallFont) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Select the outlined item with <Enter> and use Tab and Shift-Tab to move between choices. Or click with the mouse to select an item. ESC always cancels."
			)
			(513
				(gGame save:)
			)
			(514
				(gGame restore:)
			)
			(516
				(if (Print 997 6 #button {Restart} 1 #button {Continue} 0 #icon 7 0 0) ; "Do you really want to  restart your game?"
					(gGame restart:)
				)
			)
			(517
				(= gQuit
					(Print 997 7 #button {Quit} 1 #button {Continue} 0 #icon 7 0 0) ; "See you later, Commander."
				)
			)
			(769
				(= temp101 (Sound pause: 1))
				(Print 997 8 #title {Game Paused} #button {Resume} 1 #icon 7 0 0) ; "Okay. Mission on standby."
				(Sound pause: temp101)
			)
			(770
				(if (proc0_4 2048)
					(gInventory showSelf: gEgo)
				else
					(Print 997 9) ; "Sorry, not enough memory."
				)
			)
			(771
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
			)
			(1025
				(if
					(!=
						(= temp0
							(GetNumber
								(Format @temp1 {Current speed: %d} gSpeed)
							)
						)
						-1
					)
					(if (< temp0 1)
						(= temp0 1)
					)
					(if (> temp0 16)
						(= temp0 16)
					)
					(gGame setSpeed: temp0)
				)
			)
			(1027
				(if (> gSpeed 1)
					(gGame setSpeed: (-- gSpeed))
				)
			)
			(1028
				(gGame setSpeed: 6)
			)
			(1029
				(if (< gSpeed 16)
					(gGame setSpeed: (++ gSpeed))
				)
			)
			(1281
				(if
					(!=
						(= temp0
							(GetNumber {Volume (1 - 16)?} (+ 1 (DoSound sndVOLUME)))
						)
						-1
					)
					(if (< (-- temp0) 0)
						(= temp0 0)
					)
					(if (> temp0 15)
						(= temp0 15)
					)
					(DoSound sndVOLUME temp0)
				)
			)
			(1282
				(if (GetMenu 1282 113)
					(DoSound sndSET_SOUND 0)
					(SetMenu 1282 113 0 110 {Turn on})
				else
					(DoSound sndSET_SOUND 1)
					(SetMenu 1282 113 1 110 {Turn off})
				)
			)
		)
	)
)

