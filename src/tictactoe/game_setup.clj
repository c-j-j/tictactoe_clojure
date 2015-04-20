(ns tictactoe.game-setup
  (:use tictactoe.board))

(def board-sizes [{:option 3 :description "3x3 board"}
                  {:option 4 :description "4x4 board"}])

(def player-options [{:option :human :description "Human Player" }
                     {:option :computer :description "Computer Player"}])

(def board-message "Select board: ")
(def player-one-message "Select Player One: ")
(def player-two-message "Select Player Two: ")

(defn setup-board [get-option-from-user]
  (new-board (get-option-from-user board-message board-sizes)))

(defn setup-players [get-option-from-user]
  (let [player-1 (get-option-from-user player-one-message player-options)
        player-2 (get-option-from-user player-two-message player-options)]
    [{:player_type player-1} {:player_type player-2}]
    ))
