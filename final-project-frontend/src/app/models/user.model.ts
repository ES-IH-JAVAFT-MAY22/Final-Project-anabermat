export class User {
    

    constructor(
        private _id: number,
        private _username: string,
        private _password: string,
        private _balance: number
    ) {}

    public get balance(): number {
        return this._balance;
    }
    public set balance(value: number) {
        this._balance = value;
    }
   
    public get password(): string {
        return this._password;
    }
    public set password(value: string) {
        this._password = value;
    }
    public get username(): string {
        return this._username;
    }
    public set username(value: string) {
        this._username = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

    public toJSON(): object {
        return {
            id: this._id,
            username: this._username,
            password: this._password,
            balance: this._balance
        };
    }
}