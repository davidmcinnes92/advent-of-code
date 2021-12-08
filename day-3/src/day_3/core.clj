(ns day-3.core
  (:gen-class))

(require '[clojure.string :as str])

(def directions { :north 0
                  :east 1
                  :south 2
                  :west 3 
                  :south-west { :cool "Super Cool!"
                                :lame "Super Lame!"
                  }})

(def input (slurp "resources/input.txt"))
(def input-test (slurp "resources/test-input.txt"))
(def numbers (str/split-lines input))
;;(def 2d-numbers (to-array-2d input))

(defn gamma-rate []
  (def indexer (atom 0))
  (def total-0 (atom 0))
  (def total-1 (atom 0))
  (def results-array (make-array Integer/TYPE 12))
  (while (< @indexer 12)
    (do (doseq [x numbers]
      (def binary-element (Character/digit (get x @indexer) 12))
      (if (= binary-element 0) (swap! total-0 inc))
      (if (= binary-element 1) (swap! total-1 inc))))
  (if (< @total-0 @total-1) (aset-int results-array @indexer 0) (aset-int results-array @indexer 1))
  (reset! total-0 0)
  (reset! total-1 0)
  (swap! indexer inc)
  (println "indexer is" @indexer))
  (println (java.util.Arrays/toString results-array)))

(defn epsilon-rate []
  (def indexer (atom 0))
  (def total-0 (atom 0))
  (def total-1 (atom 0))
  (def results-array (make-array Integer/TYPE 12))
  (while (< @indexer 12)
    (do (doseq [x numbers]
      (def binary-element (Character/digit (get x @indexer) 12))
      (if (= binary-element 0) (swap! total-0 inc))
      (if (= binary-element 1) (swap! total-1 inc))))
  (if (> @total-0 @total-1) (aset-int results-array @indexer 0) (aset-int results-array @indexer 1))
  (reset! total-0 0)
  (reset! total-1 0)
  (swap! indexer inc)
  (println "indexer is" @indexer))
  (println (java.util.Arrays/toString results-array)))

(defn if-test []
  (def binary-element 0)
  (if (= binary-element 0) (println "Binary Element is" binary-element)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (gamma-rate)
  (epsilon-rate)
  (println directions)
  (def sub-directions (:south-west directions))
  (map remove sub-directions)
  (println directions)
  (println (:cool sub-directions))
  (println (:north directions))
  (println (directions :south))
  (println "number is "(Integer/parseInt "110011110100" 2))
  (println "number is "(Integer/parseInt "001100001011" 2))
  (println (* 3316 779))
  (println "Hello, World!"))
