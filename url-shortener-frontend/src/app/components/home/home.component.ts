import { Clipboard } from '@angular/cdk/clipboard';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UrlService } from 'src/app/services/url.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  shortUrl?: string;
  noUrl = false;

  form = this.formBuilder.group({
    url: ['', [Validators.required]],
  });

  constructor(
    private formBuilder: FormBuilder,
    private urlService: UrlService,
    private clipboard: Clipboard
  ) {}

  ngOnInit(): void {}

  send() {
    const url = this.form.controls['url'].value;

    if (!url?.startsWith('https://') && !url?.startsWith('http://')) {
      this.noUrl = true;
      return;
    }

    this.noUrl = false;

    this.urlService.getShortUrl(url).subscribe({
      next: (data: any) => {
        this.shortUrl = `http://localhost:4200/${data.url}`;
      },
      error: (error) => console.error(error),
    });
  }

  copyToClipboard() {
    this.clipboard.copy(this.shortUrl || '');
  }
}
