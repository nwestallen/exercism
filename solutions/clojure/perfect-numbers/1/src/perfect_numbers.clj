(ns perfect-numbers)

(defn aliquot-sum [n]
  (reduce + 1
          (filter integer? (map (partial / n) (range 2 n)))))

(defn classify
  "Classifies the given number as perfect, abundant, or deficient."
  [num]
  (let [a (aliquot-sum num)]
    (cond
      (= num 1) :deficient
      (= a num) :perfect
      (> a num) :abundant
      (< a num) :deficient))
  )

