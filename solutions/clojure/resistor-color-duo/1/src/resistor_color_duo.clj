(ns resistor-color-duo)

(def colorlist
  ["black" "brown" "red" "orange" "yellow" "green" "blue" "violet" "grey" "white"]
  )

(defn resistor-value
  "Returns the resistor value based on the given colors."
  [colors]
  (+ (* 10 (.indexOf colorlist (first colors))) (.indexOf colorlist (second colors)))
  )
