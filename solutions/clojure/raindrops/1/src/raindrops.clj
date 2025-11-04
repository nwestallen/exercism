(ns raindrops)

(defn convert [n]
  (let [ans
  (str (if (= (mod n 3) 0) "Pling" nil)
       (if (= (mod n 5) 0) "Plang" nil)
       (if (= (mod n 7) 0) "Plong" nil))]
    (if (empty? ans) (str n) ans))
)
