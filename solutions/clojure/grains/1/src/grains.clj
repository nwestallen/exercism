(ns grains)

(defn square
  "Returns the number of grains on the n-th chessboard square."
  [n]
  (.pow (biginteger 2) (- n 1))
  )

(defn total
  "Returns the total number of grains on the chessboard."
  []
  (->> (range 1 65)
       (map square)
       (reduce +))
  )

