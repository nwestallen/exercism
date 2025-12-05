(ns pascals-triangle)

(defn row [r]
  (vec (concat [1] (map (partial reduce +) (partition 2 1 r)) [1]))
  )

(def triangle
  (iterate row [1]))


