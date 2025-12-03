(ns series)

(defn slices
  "Returns all contiguous substrings of length n from the string s."
  [s n]
  (let [ls (count s)]
    (cond
      (= ls 0) (throw (IllegalArgumentException. "series cannot be empty"))
      (= n 0) (throw (IllegalArgumentException. "slice length cannot be zero"))
      (> n ls) (throw (IllegalArgumentException. "slice length cannot be greater than series length"))
      (< n 0)  (throw (IllegalArgumentException. "slice length cannot be negative"))
      :else (mapv (partial apply str) (partition n 1 s)))))

