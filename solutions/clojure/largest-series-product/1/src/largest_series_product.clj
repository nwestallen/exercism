(ns largest-series-product)

(defn str-prod [string]
  (reduce * (map #(Character/digit % 10) string))
  )

(defn largest-product
  "Returns the largest product of any consecutive digits of length span
  in the string s."
  [span s]
  (cond
    (< span 0) (throw (IllegalArgumentException. "span must not be negative"))
    (> span (count s)) (throw (IllegalArgumentException. "span must not exceed string length"))
    (not (re-matches #"\d+" s)) (throw (IllegalArgumentException. "digits input must only contain digits"))
    :else (apply max (map str-prod (partition span 1 s)))
    ))

