;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 998)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use Motion)
(use System)

(class PicView of Feature
	(properties
		view 0
		loop 0
		cel 0
		priority -1
		signal 0
		palette 0
	)

	(method (showSelf)
		(Print name #icon view loop cel)
	)

	(method (init)
		(gAddToPics add: self)
		(SetNowSeen self)
		(super init: &rest)
	)

	(method (onMe)
		(return
			(if (& signal $0080)
				0
			else
				(super onMe: &rest)
			)
		)
	)
)

(class View of Feature
	(properties
		yStep 2
		view 0
		loop 0
		cel 0
		priority 0
		underBits 0
		signal 257
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		palette 0
	)

	(method (init theInitializer)
		(&= signal $7fff)
		(if (not (gCast contains: self))
			(= lsRight (= lsBottom (= lsLeft (= lsTop 0))))
			(&= signal $ff77)
		)
		(BaseSetter self)
		(super init: &rest)
		(self checkDetail:)
	)

	(method (posn newX newY newZ)
		(if (>= argc 1)
			(= x newX)
			(if (>= argc 2)
				(= y newY)
				(if (>= argc 3)
					(= z newZ)
				)
			)
		)
		(BaseSetter self)
		(self forceUpd:)
	)

	(method (dispose)
		(self startUpd: hide:)
		(|= signal $8000)
	)

	(method (hide)
		(|= signal $0008)
	)

	(method (show)
		(&= signal $fff7)
	)

	(method (delete)
		(if (& signal $8000)
			(&= signal $7fff)
			(gCast delete: self)
			(if underBits
				(UnLoad 133 underBits)
				(= underBits 0)
			)
			(if (& signal $0020)
				(gAddToPics
					add:
						((PicView new:)
							view: view
							loop: loop
							cel: cel
							x: x
							y: y
							z: z
							priority: priority
							signal: signal
							yourself:
						)
				)
				(gFeatures add: self)
			else
				(super dispose:)
			)
			(if (IsObject actions)
				(actions dispose:)
			)
			(= actions 0)
		)
	)

	(method (stopUpd)
		(|= signal $0001)
		(&= signal $fffd)
	)

	(method (forceUpd)
		(|= signal $0040)
	)

	(method (startUpd)
		(|= signal $0002)
		(&= signal $fffe)
	)

	(method (setPri newPri)
		(cond
			((== argc 0)
				(|= signal $0010)
			)
			((== newPri -1)
				(&= signal $ffef)
			)
			(else
				(= priority newPri)
				(|= signal $0010)
			)
		)
		(self forceUpd:)
	)

	(method (setLoop newLoop)
		(cond
			((== argc 0)
				(|= signal $0800)
			)
			((== newLoop -1)
				(&= signal $f7ff)
			)
			(else
				(= loop newLoop)
				(|= signal $0800)
			)
		)
		(self forceUpd:)
	)

	(method (setCel newCel)
		(cond
			((== argc 0)
				(|= signal $1000)
			)
			((== newCel -1)
				(&= signal $efff)
			)
			(else
				(|= signal $1000)
				(= cel
					(if (>= newCel (self lastCel:))
						(self lastCel:)
					else
						newCel
					)
				)
			)
		)
		(self forceUpd:)
	)

	(method (ignoreActors arg)
		(if (or (== 0 argc) arg)
			(|= signal $4000)
		else
			(&= signal $bfff)
		)
	)

	(method (addToPic)
		(if (not (gCast contains: self))
			(self init:)
		)
		(self signal: (| signal $8021))
	)

	(method (lastCel)
		(return (- (NumCels self) 1))
	)

	(method (showSelf)
		(Print name #icon view loop cel)
	)

	(method (isExtra value &tmp ret)
		(= ret (& signal $0200))
		(if argc
			(if value
				(|= signal $0200)
			else
				(&= signal $fdff)
			)
		)
		(return ret)
	)

	(method (motionCue))

	(method (checkDetail))

	(method (isNotHidden)
		(return (not (& signal $0088)))
	)

	(method (onMe)
		(return
			(if (self isNotHidden:)
				(super onMe: &rest)
			else
				0
			)
		)
	)
)

(class Prop of View
	(properties
		signal 0
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
	)

	(method (doit &tmp aState)
		(SetNowSeen self nsTop)
		(if (& signal $8000)
			(return)
		)
		(if script
			(script doit:)
		)
		(if (and (& signal $0004) (not (& signal $0002)))
			(return)
		)
		(if cycler
			(cycler doit:)
		)
	)

	(method (handleEvent event)
		(if script
			(script handleEvent: event)
		)
		(super handleEvent: event)
	)

	(method (setCycle cType)
		(if cycler
			(cycler dispose:)
		)
		(if cType
			(self setCel: -1)
			(self startUpd:)
			(= cycler
				(if (& (cType -info-:) $8000)
					(cType new:)
				else
					cType
				)
			)
			(cycler init: self &rest)
		else
			(= cycler 0)
		)
	)

	(method (delete)
		(if (& signal $8000)
			(self setScript: 0 setCycle: 0)
			(if timer
				(timer dispose:)
			)
			(super delete:)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)

	(method (setScript newScript)
		(if (IsObject script)
			(script dispose:)
		)
		(if newScript
			(newScript init: self &rest)
		)
	)

	(method (motionCue)
		(if (and cycler (cycler completed:))
			(cycler motionCue:)
		)
	)

	(method (checkDetail theLevel)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						theLevel
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			(cycler
				(self startUpd:)
			)
		)
	)
)

(class Actor of Prop
	(properties
		illegalBits $8000
		xLast 0
		yLast 0
		xStep 3
		moveSpeed 6
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		code 0
	)

	(method (init)
		(super init: &rest)
		(= xLast x)
		(= yLast y)
	)

	(method (doit &tmp aState left right)
		(if (& signal $8000)
			(return)
		)
		(if script
			(script doit:)
		)
		(if code
			(code doit: self)
		)
		(if (and (& signal $0004) (not (& signal $0002)))
			(return)
		)
		(if viewer
			(viewer doit: self)
		)
		(cond
			(avoider
				(avoider doit:)
			)
			(mover
				(mover doit:)
			)
		)
		(if cycler
			(= left brLeft)
			(= right brRight)
			(cycler doit:)
			(if baseSetter
				(baseSetter doit: self)
			else
				(BaseSetter self)
			)
		)
		(= xLast x)
		(= yLast y)
	)

	(method (posn newX newY)
		(super posn: newX newY &rest)
		(= xLast newX)
		(= yLast newY)
	)

	(method (setMotion mType)
		(if (and mover (!= mover -1))
			(mover dispose:)
		)
		(if mType
			(self startUpd:)
			(= mover
				(if (& (mType -info-:) $8000)
					(mType new:)
				else
					mType
				)
			)
			(mover init: self &rest)
		else
			(= mover 0)
		)
	)

	(method (setAvoider))

	(method (isStopped)
		(return
			(or
				(not (IsObject mover))
				(and (== x (mover xLast:)) (== y (mover yLast:)))
			)
		)
	)

	(method (isBlocked)
		(return (& signal $0400))
	)

	(method (delete)
		(if (& signal $8000)
			(if (!= mover -1)
				(self setMotion: 0)
			)
			(if baseSetter
				(baseSetter dispose:)
				(= baseSetter 0)
			)
			(if looper
				(looper dispose:)
				(= looper 0)
			)
			(if viewer
				(viewer dispose:)
				(= viewer 0)
			)
			(if blocks
				(blocks dispose:)
				(= blocks 0)
			)
			(if code
				(code dispose:)
				(= code 0)
			)
			(if (IsObject actions)
				(actions dispose:)
				(= actions 0)
			)
			(super delete:)
		)
	)

	(method (ignoreHorizon))

	(method (observeControl &tmp temp0))

	(method (ignoreControl &tmp temp0))

	(method (observeBlocks))

	(method (ignoreBlocks))

	(method (distanceTo anObj)
		(GetDistance x y (anObj x:) (anObj y:) gPerspective)
	)

	(method (cantBeHere &tmp ret))

	(method (findPosn &tmp [temp0 5]))

	(method (inRect lx uy rx by)
		(return (and (<= lx x) (< x rx) (<= uy y) (< y by)))
	)

	(method (onControl))

	(method (setStep xs ys)
		(if (and (>= argc 1) (!= xs -1))
			(= xStep xs)
		)
		(if (and (>= argc 2) (!= ys -1))
			(= yStep ys)
		)
		(if (and mover (!= -1 mover) (mover isMemberOf: MoveTo))
			((self mover:) init:)
		)
	)

	(method (setDirection dir &tmp vx vy xIncr yIncr ang maxCoord pathPts obs)
		(= vx
			(if (== (= vy (gCurRoom vanishingY:)) -30000)
				x
			else
				(gCurRoom vanishingX:)
			)
		)
		(if (and (== xStep 0) (== yStep 0))
			(return)
		)
		(= maxCoord (/ 32000 (Max xStep yStep)))
		(switch dir
			(0
				(self setMotion: 0)
				(return)
			)
			(1
				(= xIncr (- vx x))
				(= yIncr (- vy y))
			)
			(5
				(= xIncr (- x vx))
				(= yIncr (- y vy))
			)
			(3
				(= xIncr maxCoord)
				(= yIncr 0)
			)
			(7
				(= xIncr (- maxCoord))
				(= yIncr 0)
			)
			(else
				(if (< 180 (= ang (GetAngle x y vx vy)))
					(-= ang 360)
				)
				(= ang (+ (/ (+ ang 90) 2) (* 45 (- dir 2))))
				(= xIncr (SinMult ang 100))
				(= yIncr (- (CosMult ang 100)))
			)
		)
		(/= maxCoord 5)
		(while (and (< (Abs yIncr) maxCoord) (< (Abs xIncr) maxCoord))
			(*= xIncr 5)
			(*= yIncr 5)
		)
		(if (and (= obs (gCurRoom obstacles:)) gUseObstacles)
			(= pathPts
				(AvoidPath
					x
					y
					(+ x xIncr)
					(+ y yIncr)
					(obs elements:)
					(obs size:)
					0
				)
			)
			(= xIncr (- (WordAt pathPts 2) x))
			(= yIncr (- (WordAt pathPts 3) y))
			(Memory memFREE pathPts)
		)
		(cond
			((or xIncr yIncr)
				(self setMotion: MoveTo (+ x xIncr) (+ y yIncr))
			)
			(dir
				(self setMotion: 0 setHeading: (* (- dir 1) 45))
			)
			(else
				(self setMotion: 0)
			)
		)
	)

	(method (motionCue)
		(if (and mover (mover completed:))
			(mover motionCue:)
		)
		(super motionCue:)
	)

	(method (setLoop l &tmp newLooper)
		(if
			(= newLooper
				(cond
					((== argc 0)
						(super setLoop:)
						0
					)
					((not (IsObject l))
						(super setLoop: l &rest)
						0
					)
					((& (l -info-:) $8000)
						(l new:)
					)
					(else l)
				)
			)
			(if looper
				(looper dispose:)
			)
			((= looper newLooper) init: self &rest)
		)
	)

	(method (checkDetail theLevel)
		(cond
			((not detailLevel))
			(
				(<
					(if argc
						theLevel
					else
						(gGame detailLevel:)
					)
					detailLevel
				)
				(self stopUpd:)
			)
			((or cycler mover)
				(self startUpd:)
			)
		)
	)

	(method (setHeading h whoCares)
		(if argc
			(= heading h)
		)
		(if looper
			(looper doit: self heading (and (>= argc 2) whoCares))
		else
			(DirLoop self heading)
			(if (and (>= argc 2) (IsObject whoCares))
				(whoCares cue: &rest)
			)
		)
		(return heading)
	)
)

