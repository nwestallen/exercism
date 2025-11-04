(ns all-your-base)

(defn convert [baseA digits baseB]
  (if (or (< baseA 2) (< baseB 2) (some #(or (<= baseA %) (< % 0)) digits))
    nil
    (if (empty? digits)
      '()
      (let [dec
            (reduce
             +
             (map-indexed
              (fn [idx digit] (* digit (Math/pow baseA idx)))
              (reverse digits)))]

        (if (= (int dec) 0)
          '(0)
          (loop [qnum (int dec) newdigs '()]
            (if (= qnum 0)
              newdigs
              (recur (quot qnum baseB) (conj newdigs (rem qnum baseB))))))))))
