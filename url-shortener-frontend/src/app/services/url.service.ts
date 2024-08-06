import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UrlService {
  private readonly baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getShortUrl(url: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}?url=${encodeURIComponent(url)}`);
  }

  getOriginalUrl(shortUrl: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${shortUrl}`);
  }
}
