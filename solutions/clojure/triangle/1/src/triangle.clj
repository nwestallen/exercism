(ns triangle)

(defn triangle? [a b c]
  (let [sides (sort > (list a b c))]
  (and (> a 0) (> b 0) (> c 0) (>= (apply + (rest sides)) (first sides)))
  )
  )

(defn equilateral?
  "Returns true if the triangle with sides a, b, and c is equilateral;
  otherwise, it returns false."
  [a b c]
  (and (triangle? a b c) (= a b) (= b c))
  )

(defn isosceles?
  "Returns true if the triangle with sides a, b, and c is isosceles;
  otherwise, it returns false."
  [a b c]
  (and (triangle? a b c) (or (= a b) (= a c) (= b c)))
  )

(defn scalene?
  "Returns true if the triangle with sides a, b, and c is scalene;
  otherwise, it returns false."
  [a b c]
  (and (triangle? a b c) (not (isosceles? a b c)))
  )

