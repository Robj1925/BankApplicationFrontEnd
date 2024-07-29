var Voting = /** @class */ (function () {
    function Voting(upvotes, downvotes) {
        this.upvotes = 0;
        this.downvotes = 0;
        this.upvoteSelected = false;
        this.downvoteSelected = false;
        this.downvotes = downvotes;
        this.upvotes = upvotes;
    }
    Voting.prototype.upvote = function () {
        this.upvotes++;
        this.upvoteSelected = true;
        this.downvoteSelected = false;
        console.log(this);
    };
    Voting.prototype.downvote = function () {
        this.downvotes++;
        this.downvoteSelected = true;
        this.upvoteSelected = false;
        console.log(this);
    };
    return Voting;
}());
var test = new Voting(6, 7);
test.downvote();
test.upvote();
console.log(test.downvotes);
