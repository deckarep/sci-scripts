;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 804)
(include sci.sh)
(use Main)

(public
	proc804_0 0
)

(procedure (proc804_0)
	(cond
		((== (Graph grGET_COLOURS) 256)
			(= global129 (Palette palFIND_COLOR 31 31 31))
			(= global155 (Palette palFIND_COLOR 63 63 63))
			(= global156 (Palette palFIND_COLOR 95 95 95))
			(= global157 (Palette palFIND_COLOR 127 127 127))
			(= global158 (Palette palFIND_COLOR 159 159 159))
			(= global161 (Palette palFIND_COLOR 191 191 191))
			(= global130 (Palette palFIND_COLOR 223 223 223))
			(= global131 (Palette palFIND_COLOR 151 27 27))
			(= global132 (Palette palFIND_COLOR 231 103 103))
			(= global133 (Palette palFIND_COLOR 235 135 135))
			(= global134 (Palette palFIND_COLOR 187 187 35))
			(= global135 (Palette palFIND_COLOR 219 219 39))
			(= global136 (Palette palFIND_COLOR 223 223 71))
			(= global150 (Palette palFIND_COLOR 27 151 27))
			(= global137 (Palette palFIND_COLOR 71 223 71))
			(= global138 (Palette palFIND_COLOR 135 235 135))
			(= global139 (Palette palFIND_COLOR 23 23 119))
			(= global149 (Palette palFIND_COLOR 35 35 187))
			(= global152 (Palette palFIND_COLOR 71 71 223))
			(= global153 (Palette palFIND_COLOR 135 135 235))
			(= global140 (Palette palFIND_COLOR 219 39 219))
			(= global141 (Palette palFIND_COLOR 27 151 151))
		)
		((== (Graph grGET_COLOURS) 32)
			(= global129 17)
			(= global149 23)
			(= global150 26)
			(= global141 24)
			(= global131 30)
			(= global140 21)
			(= global135 18)
			(= global155 16)
			(= global156 16)
			(= global152 25)
			(= global137 27)
			(= global127 25)
			(= global132 20)
			(= global128 22)
			(= global136 18)
			(= global130 19)
		)
		((== (Graph grGET_COLOURS) 16)
			(= global129 17)
			(= global149 23)
			(= global150 26)
			(= global141 24)
			(= global131 30)
			(= global140 21)
			(= global135 18)
			(= global155 16)
			(= global156 16)
			(= global152 25)
			(= global137 27)
			(= global127 25)
			(= global132 20)
			(= global128 22)
			(= global136 18)
			(= global130 19)
		)
	)
)
