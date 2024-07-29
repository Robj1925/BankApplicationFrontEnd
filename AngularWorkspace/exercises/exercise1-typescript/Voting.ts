class Voting {
    upvotes = 0;
    downvotes: number = 0;
    upvoteSelected = false;
    downvoteSelected = false;

    constructor(upvotes: number, downvotes: number) {
        this.downvotes = downvotes;
        this.upvotes = upvotes;
    }
     upvote() : void {
        this.upvotes++;
        this.upvoteSelected = true;
        this.downvoteSelected = false;
        console.log(this);
    }
    downvote() : void {
        this.downvotes++;
        this.downvoteSelected = true;
        this.upvoteSelected = false;
        console.log(this);
    }
}
const test = new Voting(6, 7);
test.downvote();
test.upvote();
console.log(test.downvotes)