(ns matrix
  (:require [clojure.string :as str]))

(def testmatrix
  "1 2 3\n4 5 6\n7 8 9\n8 7 6" )

(defn convert-matrix
  "Parses string into vector of vectors"
  [matrix]
  (->> matrix
       str/split-lines
       (mapv #(str/split % #" "))
       (mapv #(mapv Integer/parseInt %)))
)

(defn get-row
  "Returns the i-th row of the matrix."
  [matrix i]
  (nth (convert-matrix matrix) (- i 1))
  )

(defn get-column
  "Returns the i-th column of the matrix."
  [matrix i]
  (mapv #(nth % (- i 1)) (convert-matrix matrix))
  )

