(ns day-2.core
  (:gen-class))

(require '[clojure.string :as str])

(def input (slurp "resources/input.txt"))
(def input-test (slurp "resources/input-test.txt"))
(def lines (str/split-lines input))
(def horizontal-position (atom 0))
(def depth (atom 0))
(def aim (atom 0))

(defn position-depth-product []
  (* @horizontal-position @depth))

(defn depth-increase [horizontal-position-increase aim]
  (* horizontal-position-increase aim))

(defn dive [command units]
  (cond
    (= command "forward") (reset! horizontal-position (+ @horizontal-position units))
    (= command "down") (reset! depth (+ @depth units))
    (= command "up") (reset! depth (- @depth units))))

(defn dive-aim [command units]
  (cond
    (= command "forward") (do 
      (reset! horizontal-position (+ @horizontal-position units))
      (def depth-increase-total (depth-increase units @aim))
      (if (= depth-increase-total 0) (println "Aim is 0 - so no depth increase") (reset! depth (+ @depth depth-increase-total))))
    (= command "down") (reset! aim (+ @aim units))
    (= command "up") (reset! aim (- @aim units))))

(defn process-input [input]
  (doseq [x input]
    (def instruction (str/split x #" "))
    (def command (nth instruction 0))
    (def units (Long/parseLong (nth instruction 1)))
    (dive-aim command units)))

(defn -main
  [& args]
  (process-input lines)
  (println "The position depth product is:" (position-depth-product)))
