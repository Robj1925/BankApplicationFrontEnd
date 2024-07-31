import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'uppercase',
  standalone: true
})
export class UppercasePipe implements PipeTransform {

  transform(text: string, args?: any[]): string {
    return  text.split(' ').map((word: string) => word[0].toUpperCase() + word.substring(1)).join(' ');
  }
}
