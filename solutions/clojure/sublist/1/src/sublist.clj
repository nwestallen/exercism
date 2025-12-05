(ns sublist)

(defn sublist? [smalllist biglist count]
  (contains? (set (partition count 1 biglist)) smalllist)
  )

(defn classify
  "Returns:
  :equal if coll1 equals coll2,
  :superlist if coll1 is a superlist of coll2,
  :sublist if coll1 is a sublist of coll2,

  If none of these conditions is true, it returns :unequal."
  [coll1 coll2]
  (let [cnt1 (count coll1)
        cnt2 (count coll2)]
    (cond (= cnt1 cnt2) (if (= coll1 coll2) :equal :unequal)
          (> cnt1 cnt2) (if (sublist? coll2 coll1 cnt2) :superlist :unequal)
          :else (if (sublist? coll1 coll2 cnt1) :sublist :unequal)
    )
    )
  )

