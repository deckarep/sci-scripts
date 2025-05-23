;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 109)
(include sci.sh)
(use Main)
(use Sound)
(use Actor)

(class Button of Prop
	(properties
		active 1
		allowModifiers 0
		upView -1
		upLoop -1
		upCel 0
		downView -1
		downLoop -1
		downCel 1
		useRect 1
		keyMessage -1
		doVerbCalled 0
	)

	(method (init)
		(if (== upView -1)
			(= upView view)
		)
		(if (== upLoop -1)
			(= upLoop loop)
		)
		(if (== downView -1)
			(= downView view)
		)
		(if (== downLoop -1)
			(= downLoop loop)
		)
		(if active
			(self view: upView loop: upLoop cel: upCel)
		else
			(self view: downView loop: downLoop cel: downCel)
		)
		(super init: &rest)
		(if (!= keyMessage -1)
			(gDirectionHandler add: self)
			(gKeyDownHandler add: self)
		)
		(gMouseDownHandler addToFront: self)
	)

	(method (onMe param1 &tmp temp0)
		(if (and (not (= temp0 (super onMe: param1))) useRect)
			(= temp0
				(and
					(<= nsLeft (param1 x:) nsRight)
					(<= nsTop (param1 y:) nsBottom)
				)
			)
		)
		(return temp0)
	)

	(method (handleEvent event)
		(if (not (gUser input:))
			(event claimed: 1)
			(return)
		)
		(if (or (not active) (event claimed:))
			(return)
		)
		(event localize: plane)
		(if (and (not (event type:)) (self onMe: event))
			(self doVerb: 1)
			(event claimed: 1)
			(return)
		)
		(if
			(or
				(and (& (event type:) evMOUSE) (not (self onMe: event)))
				(not (event type:))
				(and (not allowModifiers) (event modifiers:))
			)
			(super handleEvent: event)
			(return)
		)
		(if (& (event type:) $0014) ; direction | evKEYBOARD
			(if (and (!= keyMessage -1) (== keyMessage (event message:)))
				(self doVerb: 2)
				(event claimed: 1)
			)
			(event claimed:)
			(return)
		)
		(if (& (event type:) evMOUSEBUTTON)
			(self trace: event)
		)
		(event claimed:)
	)

	(method (trace param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp1 0)
		(= temp7 0)
		(= temp6 (= temp8 0))
		(while 1
			(= temp5 temp1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(param1 type: 0 message: 0 modifiers: 0 y: 0 x: 0 plane: 0)
			(GetEvent evMOUSE param1)
			(param1 localize: plane)
			(if (& (param1 type:) $0002)
				(break)
			else
				(= temp2 view)
				(= temp3 loop)
				(= temp4 cel)
				(if (self onMe: param1)
					(self view: downView loop: downLoop cel: downCel)
					(= temp1 1)
					(if
						(and
							doVerbCalled
							(or
								(not temp8)
								(and
									(< temp6 60)
									(= temp6 (Abs (- temp8 gGameTime)))
									0
								)
								(and (>= temp6 60) (<= (-- temp7) 0))
							)
						)
						(= temp8 gGameTime)
						(= temp7 20)
						(self doVerb: 2)
					)
				else
					(self view: upView loop: upLoop cel: upCel)
					(= temp1 0)
				)
			)
			(if (or (!= temp2 view) (!= temp3 loop) (!= temp4 cel))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (!= temp5 temp1)
				(= temp5 temp1)
				temp1
			)
		)
		(if active
			(self view: upView loop: upLoop cel: upCel)
			(UpdateScreenItem self)
			(FrameOut)
		)
		(if (and temp1 (not doVerbCalled))
			(self doVerb: 2)
		)
		(param1 claimed: 1)
	)

	(method (doVerb theVerb)
		(if (buttonSound handle:)
			(buttonSound stop:)
		)
		(if code
			(code doit:)
		)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(buttonSound stop: dispose:)
		(self deleteHotspot:)
		(super dispose: &rest)
	)

	(method (setActive param1)
		(if (or (not argc) param1)
			(self view: upView loop: upLoop cel: upCel active: 1 case: 8)
		else
			(self view: downView loop: downLoop cel: downCel active: 0 case: 7)
		)
		(UpdateScreenItem self)
	)

	(method (checkEvent param1 &tmp temp0 temp1)
		(= temp1 (param1 plane:))
		(param1 localize: plane)
		(= temp0
			(if active
				(self onMe: param1)
			)
		)
		(if temp1
			(param1 localize: temp1)
		else
			(param1 globalize:)
		)
		(return temp0)
	)

	(method (setCursor param1)
		(if param1
			(gTheCursor view: 999 loop: 0 cel: 0)
		)
		(global123 setCursor:)
	)
)

(instance buttonSound of Sound
	(properties
		flags 5
	)
)

