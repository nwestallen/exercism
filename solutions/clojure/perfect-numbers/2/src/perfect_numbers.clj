(ns perfect-numbers)

(defn factors [n]
  (filter integer? (map #(+ % (/ n %)) (range 2 (Math/sqrt n)))))

(defn aliquot-sum [n]
  (reduce + 1
          (factors n)))

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

