(ns strain)

(defn retain
  "Keeps the items in coll for which (pred item) returns true."
  [pred coll]
  (loop [c coll
         result []]
    (if (empty? c) result
      (recur  (rest c) (if (pred (first c)) (conj result (first c)) result))
      )
    )
  )

(defn discard
  "Removes the items in coll for which (pred item) returns true."
  [pred coll]
  (retain #(not (pred %)) coll)
  )

