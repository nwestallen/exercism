(ns flatten-array)

(def testcoll [0 2 [[2 3 nil] 8 nil 100 4 [[[50]]]] -2])

(defn flatten
  "Flattens the given sequential collection.
  Nil values are excluded from the result."
  [coll]
  (vec (remove nil? (clojure.core/flatten coll)))
  )

