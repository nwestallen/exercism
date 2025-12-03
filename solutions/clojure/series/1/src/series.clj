(ns series)

(defn slices
  "Returns all contiguous substrings of length n from the string s."
  [s n]
  (mapv (partial apply str) (partition n 1 s))
  )

;; There is no place to leave feedback on exercies, so I'm submitting this iteration with tests failing deliberately, because nowhere in the reademe/instructions
;; is exception handling mentioned, in fact, the instructions are dismissive, "And if you ask for a 6-digit series from a 5-digit string, you deserve whatever you get."
;; The instructions should be updated to specify that exceptions should be handled!

