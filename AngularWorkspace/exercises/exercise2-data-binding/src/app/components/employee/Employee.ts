export class Employee {
    private _name: string;
    private _age: number;
    constructor(name: string, age: number) {
        this._name = name;
        this._age = age;
    }
    public getName() {
        return this._name;

    }
    public getAge() {
        return this._age;
    }
}