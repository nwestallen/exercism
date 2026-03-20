namespace hellmath {

// account types: `troll`, `guest`, `user`, and `mod`.
  enum class AccountStatus {
    troll,
    guest,
    user,
    mod
  };

// permission types: `read`, `write`, and `remove`.
  enum class Action {
    read,
    write,
    remove
  };

// of `AccountStatus` and returns a `bool`. The first argument is the status of
// the poster, the second one is the status of the viewer.
  bool display_post (AccountStatus poster, AccountStatus viewer) {
    return poster != AccountStatus::troll || poster == viewer;
  }

// `Action` as a first argument and an `AccountStatus` to check against. It
// should return a `bool`.
  bool permission_check (Action act, AccountStatus actor) {
    if (actor == AccountStatus::mod || act == Action::read) {
      return true;
    } else if (actor != AccountStatus::guest) {
      return act != Action::remove;
    } else {
      return false;
    }
  }

// checks if two players can join the same game. The function has two parameters
// of type `AccountStatus` and returns a `bool`.
  bool valid_player_combination (AccountStatus p1, AccountStatus p2) {
    if (p1 == AccountStatus::guest || p2 == AccountStatus::guest) {
      return false;
    } else if (p1 != AccountStatus::troll && p2 != AccountStatus::troll) {
      return true;
    } else {
      return p1 == p2;
    }
  }

// TODO: Task 5 - Implement the `has_priority` function that takes two
// `AccountStatus` arguments and returns `true`, if and only if the first
// account has a strictly higher priority than the second.
  bool has_priority (AccountStatus p1, AccountStatus p2) {
    switch(p2) {
    case AccountStatus::mod:
      return false;
    case AccountStatus::user:
      return p1 == AccountStatus::mod;
    case AccountStatus::guest:
      return p1 == AccountStatus::mod || p1 == AccountStatus::user;
    default:
      return p1 != AccountStatus::troll;
    }
  }
}  // namespace hellmath
