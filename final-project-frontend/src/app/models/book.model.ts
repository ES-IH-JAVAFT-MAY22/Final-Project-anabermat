

export class Book {

    constructor(
        private _id: number,
        private _title: string,
        private _numberOfPages: number,
        private _writer: string
    ) {}

    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get title(): string {
        return this._title;
    }
    public set title(value: string) {
        this._title = value;
    }

    public get numberOfPages(): number {
        return this._numberOfPages;
    }
    public set numberOfPages(value: number) {
        this._numberOfPages = value;
    }
    
    
    public get writer(): string {
        return this._writer;
    }
    public set writer(value: string) {
        this._writer = value;
    }

    public toJSON(): any {
        return {
            title: this.title,
            numberOfPages: this.numberOfPages,
            writer: this.writer,
        };
    
    }

}
