(ns sum-of-multiples)

(defn sum-of-multiples
  "Calculates the sum of multiples of the given numbers
  that are less than the limit."
  [numbers limit]
  (reduce + (set (apply concat (map #(range % limit %) numbers))))
  )

