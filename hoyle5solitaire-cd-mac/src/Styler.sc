;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64909)
(include sci.sh)
(use Main)
(use System)

(public
	ShakePlane 0
)

(procedure (ShakePlane aPlane shakeDir numShakes magnitude &tmp l t r b l1 t1 r1 b1 l2 t2 r2 b2 m n d) ; UNUSED
	(= d (if (and (> argc 1) shakeDir) shakeDir else 1))
	(= n (if (> argc 2) numShakes else 20))
	(= m (if (> argc 3) magnitude else 2))
	(= l (= l1 (= l2 (aPlane left:))))
	(= t (= t1 (= t2 (aPlane top:))))
	(= r (= r1 (= r2 (aPlane right:))))
	(= b (= b1 (= b2 (aPlane bottom:))))
	(if (& d $0001)
		(-= l1 m)
		(-= r1 m)
		(+= l2 m)
		(+= r2 m)
	)
	(if (& d $0002)
		(-= t1 m)
		(-= b1 m)
		(+= t2 m)
		(+= b2 m)
	)
	1
	(while n
		(aPlane setRect: l1 t1 r1 b1)
		(UpdatePlane aPlane)
		(FrameOut)
		(aPlane setRect: l2 t2 r2 b2)
		(UpdatePlane aPlane)
		(FrameOut)
		(-- n)
	)
	(aPlane setRect: l t r b)
)

(class Styler of Obj
	(properties
		style 0
		plane 0
		seconds 1
		back -1
		priority 200
		animate 0
		refFrame 0
		divisions 0
		captureList 0
	)

	(method (doit aPlane aStyle time aBack ani &tmp xDir yDir)
		(if argc
			(= plane aPlane)
			(if (> argc 1)
				(= style aStyle)
				(if (> argc 2)
					(= seconds time)
					(if (> argc 3)
						(= back aBack)
						(if (> argc 4)
							(= animate ani)
						else
							(= animate 0)
						)
					else
						(= back -1)
					)
				else
					(= seconds 1)
				)
			else
				(= style 0)
			)
		else
			(= plane gThePlane)
		)
		(&= style $00ff)
		(cond
			((OneOf style 16 17 18 19)
				(switch style
					(16
						(= xDir (* (gEgo xStep:) -1))
						(= yDir 0)
					)
					(17
						(= xDir (gEgo xStep:))
						(= yDir 0)
					)
					(18
						(= xDir 0)
						(= yDir (* (gEgo yStep:) -1))
					)
					(19
						(= xDir 0)
						(= yDir (gEgo yStep:))
					)
				)
				(SetScroll
					plane
					xDir
					yDir
					(plane picture:)
					animate
					(gEgo cycleSpeed:)
				)
			)
			(divisions
				(SetShowStyle
					style
					plane
					seconds
					back
					priority
					animate
					refFrame
					divisions
				)
			)
			(else
				(SetShowStyle
					style
					plane
					seconds
					back
					priority
					animate
					refFrame
				)
			)
		)
	)
)

