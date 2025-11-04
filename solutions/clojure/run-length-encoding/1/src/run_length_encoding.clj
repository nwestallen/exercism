(ns run-length-encoding)

(defn encode-lead-run
  "counts repitions of first character"
  [text]
  (let [lettercount (count
                     (take-while #(= % (first text)) text))]
    (if (>= 1 lettercount) (str (first text)) (str lettercount (first text)))))

(defn drop-lead-run
  "drops all repititions of first character"
  [text]
  (apply str (drop-while #(= % (first text)) text)))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  ([plain-text]
   (run-length-encode (drop-lead-run plain-text) (encode-lead-run plain-text)))
  ([plain-text encoding]
   (if (= 0 (count plain-text))
     encoding
     (recur (drop-lead-run plain-text) (str encoding (encode-lead-run plain-text))))))

(defn get-run-length
  [cipher-text]
  (let [numcode (apply str (take-while #(Character/isDigit %) cipher-text))]
    (if (= 0 (count numcode)) 1 (Integer/parseInt numcode))))

(defn get-first-letter
  [cipher-text]
  (first (drop-while #(Character/isDigit %) cipher-text)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  ([cipher-text]
   (run-length-decode cipher-text ""))
  ([cipher-text result]
   (if (= 0 (count cipher-text))
     result
     (recur (apply str (rest (drop-while #(Character/isDigit %) cipher-text))) (str result (apply str (repeat (get-run-length cipher-text) (get-first-letter cipher-text))))))))
